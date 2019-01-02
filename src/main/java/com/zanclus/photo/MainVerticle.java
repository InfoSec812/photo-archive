package com.zanclus.photo;

import io.reactivex.Maybe;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.reactivex.config.ConfigRetriever;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.reactivex.core.http.HttpServer;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.reactivex.ext.web.handler.CorsHandler;
import io.vertx.reactivex.ext.web.handler.sockjs.SockJSHandler;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.apache.http.HttpHeaders.*;
import static org.apache.http.entity.ContentType.*;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);
  private static final String PHOTO_SVC_ADDRESS = "service.photos";
  private static final String USER_SVC_ADDRESS = "service.users";
  private static final String GROUP_SVC_ADDRESS = "service.groups";
  public static final String OPENAPI_SPEC = "/openapi.yaml";

  JsonObject loadedConfig;

  Maybe<JsonObject> initConfigRetriever() {
    // Load the default configuration from the classpath
    LOG.info("Loading configuration from file from classpath");
    ConfigStoreOptions defaultOpts = new ConfigStoreOptions().setType("file")
            .setFormat("json")
            .setConfig(new JsonObject().put("path", "photo_archive.json"));

    // If a config json file is passed at startup, load that AFTER the classpath
    // default config
    LOG.info("Loading Vert.x config from startup");
    ConfigStoreOptions startupOpts = new ConfigStoreOptions().setType("json")
            .setConfig(vertx.getOrCreateContext().config());

    // When running inside of Kubernetes, configure the application to also load
    // from a ConfigMap. This config is ONLY loaded when running inside of
    // Kubernetes or OpenShift and the `NAMESPACE` environment variable is set
    ConfigStoreOptions confOpts = new ConfigStoreOptions().setType("configmap")
            .setConfig(new JsonObject().put("name", "photo-archive-config")
                    .put("optional", true));

    // Add the default and container config options into the ConfigRetriever
    ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions()
            .addStore(defaultOpts)
            .addStore(startupOpts)
            .addStore(confOpts);

    // Create the ConfigRetriever and return the Maybe when complete
    return ConfigRetriever.create(vertx, retrieverOptions).rxGetConfig().toMaybe();
  }

  public Maybe<Boolean> databaseMigrations(JsonObject config) {
    // Merge the loaded configuration into the config for this Verticle
    loadedConfig = config;
    String dbHost = loadedConfig.getJsonObject("db").getString("host");
    Integer dbPort = loadedConfig.getJsonObject("db").getInteger("port");
    String dbUser = loadedConfig.getJsonObject("db").getString("username");
    String dbPass = loadedConfig.getJsonObject("db").getString("password");
    String dbDriver = loadedConfig.getJsonObject("db").getString("driver");
    String dbName = loadedConfig.getJsonObject("db").getString("database");
    try {
      Class.forName(dbDriver);

      String dbUrl = String.format("jdbc:postgresql://%s:%d/%s", dbHost, dbPort, dbName);
      Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
      Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
      Liquibase liquibase = new Liquibase("db/changeLog.yaml", new ClassLoaderResourceAccessor(), db);
      liquibase.update("main");
      db.close();
      conn.close();
      return Maybe.just(Boolean.TRUE);
    } catch (Exception e) {
      return Maybe.error(e);
    }
  }

  /**
   * Begin the creation of the {@link OpenAPI3RouterFactory}
   *
   * @param dbConfig A {@link Boolean} indication the status of the database configuration
   * @return An {@link OpenAPI3RouterFactory} {@link Future} to be used to
   *         complete the next Async step
   */
  private Maybe<OpenAPI3RouterFactory> provisionRouter(Boolean dbConfig) {

    if (LOG.isInfoEnabled()) {
      LOG.info("Config Loaded: {}", loadedConfig.encodePrettily());
    }

    // Instantiate the services and bind them to the event bus

    // Create the OpenAPI3RouterFactory using the API specification YAML file
    return OpenAPI3RouterFactory.rxCreate(vertx, OPENAPI_SPEC).toMaybe();
  }

  /**
   * Wire the {@link OpenAPI3RouterFactory} into the HTTP Server
   *
   * @param factory The {@link OpenAPI3RouterFactory} created in the previous step
   * @return An {@link HttpServer} if successful
   */
  Maybe<HttpServer> provisionHttpServer(OpenAPI3RouterFactory factory) {
    // Configure the HTTP Server options
    // - Listen on port 8080 on all interfaces using HTTP2 protocol
    HttpServerOptions httpOpts = new HttpServerOptions()
            .setHost(loadedConfig.getJsonObject("http").getString("address"))
            .setPort(loadedConfig.getJsonObject("http").getInteger("port")).setReuseAddress(true)
            .setSoLinger(0).setLogActivity(true);

    // TODO: Get the service proxy instances

    // Map out OpenAPI3 route to our Service Proxy implementation
//    factory.addHandlerByOperationId("getInsult", ctx -> service.rxGetREST()
//            .doOnError(e -> errorHandler(ctx, e)).subscribe(json -> sendResult(ctx, json)));

    // Map out OpenAPI3 route to our Service Proxy implementation
//    factory.addHandlerByOperationId("health", ctx -> service.rxCheck()
//            .subscribe(
//                    json -> sendResult(ctx, json),
//                    e -> errorHandler(ctx, e)
//            )
//    );

    Router api = factory.getRouter();

    Router root = Router.router(vertx);

    CorsHandler corsHandler = CorsHandler.create(".*").allowedHeader("Access-Control-Request-Method")
            .allowedHeader("Access-Control-Allow-Origin")
            .allowedHeader("Access-Control-Allow-Headers").allowedHeader("Content-Type")
            .allowedMethod(HttpMethod.GET).allowedMethod(HttpMethod.POST)
            .allowedMethod(HttpMethod.HEAD).allowedMethod(HttpMethod.PUT)
            .allowedMethod(HttpMethod.OPTIONS).allowedMethod(HttpMethod.CONNECT);

    root.route().order(0).handler(corsHandler);
    api.route().order(0).handler(corsHandler);

    root.mountSubRouter("/api/v1", api);

    BridgeOptions bOpts = new BridgeOptions()
            .addInboundPermitted(new PermittedOptions().setAddress(USER_SVC_ADDRESS))
            .addInboundPermitted(new PermittedOptions().setAddress(PHOTO_SVC_ADDRESS))
            .addInboundPermitted(new PermittedOptions().setAddress(GROUP_SVC_ADDRESS))
            .addOutboundPermitted(new PermittedOptions().setAddress(USER_SVC_ADDRESS))
            .addOutboundPermitted(new PermittedOptions().setAddress(PHOTO_SVC_ADDRESS))
            .addOutboundPermitted(new PermittedOptions().setAddress(GROUP_SVC_ADDRESS));

    SockJSHandler sockHandler = SockJSHandler.create(vertx).bridge(bOpts);

    root.route("/eventbus/*").handler(sockHandler);

    return vertx.createHttpServer(httpOpts).requestHandler(root).rxListen().toMaybe();
  }

  /**
   * Send a successful HTTP response
   *
   * @param ctx  The {@link RoutingContext} of the request
   * @param json The {@link JsonObject} body to be sent in the response
   */
  private void sendResult(RoutingContext ctx, JsonObject json) {
    ctx.response().putHeader(CONTENT_TYPE, APPLICATION_JSON.getMimeType())
            .setStatusCode(OK.code()).setStatusMessage(OK.reasonPhrase())
            .end(json.encodePrettily());
  }

  /**
   * Send an unsuccessful HTTP response
   *
   * @param ctx The {@link RoutingContext} of the request
   * @param e   The error which caused the failure
   */
  private void errorHandler(RoutingContext ctx, Throwable e) {
    ctx.response().setStatusCode(INTERNAL_SERVER_ERROR.code())
            .setStatusMessage(INTERNAL_SERVER_ERROR.reasonPhrase()).end(e.getLocalizedMessage());
  }

  @Override
  public void start(Future startFuture) {
    initConfigRetriever()
            .flatMap(this::databaseMigrations)
            .flatMap(this::provisionRouter)
            .flatMap(this::provisionHttpServer)
            .subscribe(
                    startFuture::complete,
                    startFuture::fail
            );
  }
}
