package com.zanclus.photo.archive;

import com.zanclus.photo.archive.handlers.FileUploadBodyHandler;
import com.zanclus.photo.archive.security.ApiKeyAuthHandler;
import com.zanclus.photo.archive.security.BasicAuthHandler;
import com.zanclus.photo.archive.security.BearerAuthHandler;
import com.zanclus.photo.archive.services.GroupService;
import com.zanclus.photo.archive.services.PhotoService;
import com.zanclus.photo.archive.services.UserService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.contract.RouterFactoryOptions;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.Router;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ServiceBinder;

import com.zanclus.photo.archive.services.*;
import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.security.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  HttpServer server;
  ServiceBinder serviceBinder;

  List<MessageConsumer<JsonObject>> registeredConsumers;

  /**
   * This method starts all services
   */
  private void startServices() {
    this.serviceBinder = new ServiceBinder(vertx);
    this.registeredConsumers = new ArrayList<>();

    UserService userService = UserService.create(vertx);
    registeredConsumers.add(
      serviceBinder
        .setAddress("svc.user")
        .register(UserService.class, userService)
    );
    GroupService groupService = GroupService.create(vertx);
    registeredConsumers.add(
      serviceBinder
        .setAddress("svc.group")
        .register(GroupService.class, groupService)
    );
    PhotoService photoService = PhotoService.create(vertx);
    registeredConsumers.add(
      serviceBinder
        .setAddress("svc.photo")
        .register(PhotoService.class, photoService)
    );
  }

  /**
   * This method constructs the router factory, mounts services and handlers and starts the http server with built router
   * @return
   */
  private Future<Void> startHttpServer() {
    Future<Void> future = Future.future();
    OpenAPI3RouterFactory.create(this.vertx, getClass().getResource("/openapi.yml").getFile(), openAPI3RouterFactoryAsyncResult -> {
      if (openAPI3RouterFactoryAsyncResult.succeeded()) {
        OpenAPI3RouterFactory routerFactory = openAPI3RouterFactoryAsyncResult.result();

        // Enable automatic response when ValidationException is thrown
        routerFactory.setOptions(new RouterFactoryOptions().setMountValidationFailureHandler(true));

        // Mount services on event bus based on extensions
        routerFactory.mountServicesFromExtensions();


        // Add security handlers
        routerFactory.addSecurityHandler("BasicAuth", new BasicAuthHandler());
        routerFactory.addSecurityHandler("BearerAuth", new BearerAuthHandler());
        routerFactory.addSecurityHandler("ApiKeyAuth", new ApiKeyAuthHandler());

        routerFactory.setBodyHandler(FileUploadBodyHandler.bodyHandler(vertx));

        // Generate the router
        routerFactory.mountServicesFromExtensions();
        routerFactory.mountServiceInterface(PhotoService.class, "svc.photo");
        Router apiRouter = routerFactory.getRouter();
        Router root = Router.router(vertx);
        root.mountSubRouter("/api/v1", apiRouter);
        server = vertx.createHttpServer(new HttpServerOptions().setPort(8080).setHost("localhost"));
        server.requestHandler(root).listen();
        future.complete();
      } else {
        // Something went wrong during router factory initialization
        future.fail(openAPI3RouterFactoryAsyncResult.cause());
      }
    });
    return future;
  }

  @Override
  public void start(Future<Void> future) {
    startServices();
    startHttpServer().setHandler(future.completer());
  }

  /**
   * This method closes the http server and unregister all services loaded to Event Bus
   */
  @Override
  public void stop(){
    this.server.close();
    registeredConsumers.forEach(c -> serviceBinder.unregister(c));
  }

}
