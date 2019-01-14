package com.zanclus.photo.archive.services;

import com.zanclus.photo.archive.models.Credentials;
import com.zanclus.photo.archive.models.NewUser;
import com.zanclus.photo.archive.services.impl.UserServiceImpl;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.*;
import io.vertx.ext.web.api.generator.WebApiServiceGen;

import java.util.List;
import java.util.Map;

import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.services.impl.UserServiceImpl;

@WebApiServiceGen
@ProxyGen
public interface UserService {

  static UserService create(Vertx vertx) {
    return new UserServiceImpl(vertx);
  }

  static UserService createProxy(Vertx vertx, String address) {
    return new UserServiceVertxEBProxy(vertx, address);
  }

  void userLogin(
    Credentials body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void newUser(
    NewUser body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void getUserDetailsByName(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

}
