package com.zanclus.photo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.Router;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle {

  HttpServer server;

  @Override
  public void start(Future future) {
    OpenAPI3RouterFactory.createRouterFactoryFromFile(this.vertx, getClass().getResource("/openapi.json").getFile(), openAPI3RouterFactoryAsyncResult -> {
      if (openAPI3RouterFactoryAsyncResult.succeeded()) {
        OpenAPI3RouterFactory routerFactory = openAPI3RouterFactoryAsyncResult.result();

        // Enable automatic response when ValidationException is thrown
        routerFactory.enableValidationFailureHandler(true);

        // Add routes handlers
        routerFactory.addHandlerByOperationId("userLogin", new com.zanclus.photo.handlers.UserLoginHandler());
        routerFactory.addHandlerByOperationId("newUser", new com.zanclus.photo.handlers.NewUserHandler());
        routerFactory.addHandlerByOperationId("getUserDetailsByName", new com.zanclus.photo.handlers.GetUserDetailsByNameHandler());
        routerFactory.addHandlerByOperationId("newGroup", new com.zanclus.photo.handlers.NewGroupHandler());
        routerFactory.addHandlerByOperationId("getGroupById", new com.zanclus.photo.handlers.GetGroupByIdHandler());
        routerFactory.addHandlerByOperationId("updateGroupById", new com.zanclus.photo.handlers.UpdateGroupByIdHandler());
        routerFactory.addHandlerByOperationId("addUserToGroup", new com.zanclus.photo.handlers.AddUserToGroupHandler());
        routerFactory.addHandlerByOperationId("deleteUserFromGroup", new com.zanclus.photo.handlers.DeleteUserFromGroupHandler());
        routerFactory.addHandlerByOperationId("addPhoto", new com.zanclus.photo.handlers.AddPhotoHandler());
        routerFactory.addHandlerByOperationId("getImageById", new com.zanclus.photo.handlers.GetImageByIdHandler());
        routerFactory.addHandlerByOperationId("updateImageById", new com.zanclus.photo.handlers.UpdateImageByIdHandler());
        routerFactory.addHandlerByOperationId("deleteImageById", new com.zanclus.photo.handlers.DeleteImageByIdHandler());
        routerFactory.addHandlerByOperationId("getTagsByPhotoId", new com.zanclus.photo.handlers.GetTagsByPhotoIdHandler());
        routerFactory.addHandlerByOperationId("addTagToPhoto", new com.zanclus.photo.handlers.AddTagToPhotoHandler());
        routerFactory.addHandlerByOperationId("deleteTagFromPhoto", new com.zanclus.photo.handlers.DeleteTagFromPhotoHandler());

        // Add security handlers
        routerFactory.addSecurityHandler("BasicAuth", new com.zanclus.photo.securityHandlers.BasicAuthSecurityHandler());
        routerFactory.addSecurityHandler("BearerAuth", new com.zanclus.photo.securityHandlers.BearerAuthSecurityHandler());
        routerFactory.addSecurityHandler("ApiKeyAuth", new com.zanclus.photo.securityHandlers.ApiKeyAuthSecurityHandler());

        // Generate the router
        Router router = routerFactory.getRouter();
        server = vertx.createHttpServer(new HttpServerOptions().setPort(8080).setHost("localhost"));
        server.requestHandler(router::accept).listen();
        future.complete();
      } else {
          // Something went wrong during router factory initialization
          Throwable exception = openAPI3RouterFactoryAsyncResult.cause();
      }
    });
  }

  @Override
  public void stop(){
    this.server.close();
  }

}
