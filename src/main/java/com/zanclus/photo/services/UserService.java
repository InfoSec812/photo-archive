package com.zanclus.photo.services;

import com.zanclus.photo.services.impl.UserServiceImpl;
import com.zanclus.photo.services.types.Credentials;
import com.zanclus.photo.services.types.NewUser;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.Vertx;

@ProxyGen
@VertxGen
public interface UserService {

  static UserService create(Vertx vertx) {
    return new UserServiceImpl(vertx, vertx.getOrCreateContext().config());
  }

  static UserService createProxy(Vertx vertx, String address) {
    return new UserServiceVertxEBProxy(vertx, address);
  }

  void userLogin(Credentials credentials, Handler<AsyncResult<JsonObject>> handler);

  void newUser(NewUser newUser, Handler<AsyncResult<JsonObject>> handler);

  void getUserDetailsByName(String id, Handler<AsyncResult<JsonObject>> handler);
}