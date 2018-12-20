package com.zanclus.photo.services.impl;

import com.zanclus.photo.services.UserService;
import com.zanclus.photo.types.Credentials;
import com.zanclus.photo.types.NewUser;

import org.apache.commons.lang3.NotImplementedException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

public class UserServiceImpl implements UserService {

  private JsonObject config;
  private Vertx vertx;

  public UserServiceImpl(io.vertx.core.Vertx vertx, JsonObject config) {
    this.config = config;
    this.vertx = Vertx.newInstance(vertx);
  }

  @Override
  public void userLogin(Credentials credentials, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void newUser(NewUser newUser, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void getUserDetailsByName(String id, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }
}