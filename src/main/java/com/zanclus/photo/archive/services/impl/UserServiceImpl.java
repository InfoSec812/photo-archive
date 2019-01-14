package com.zanclus.photo.archive.services.impl;

import com.zanclus.photo.archive.models.Credentials;
import com.zanclus.photo.archive.models.NewUser;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.*;

import java.util.List;
import java.util.Map;

import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.services.UserService;

public class UserServiceImpl implements UserService {

  private Vertx vertx;

  public UserServiceImpl(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public void userLogin(
    Credentials body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void newUser(
    NewUser body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void getUserDetailsByName(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

}
