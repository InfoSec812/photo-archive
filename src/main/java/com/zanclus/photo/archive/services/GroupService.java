package com.zanclus.photo.archive.services;

import com.zanclus.photo.archive.models.NewGroup;
import com.zanclus.photo.archive.services.impl.GroupServiceImpl;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.*;
import io.vertx.ext.web.api.generator.WebApiServiceGen;

import java.util.List;
import java.util.Map;

import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.services.impl.GroupServiceImpl;

@WebApiServiceGen
@ProxyGen
public interface GroupService {

  static GroupService create(Vertx vertx) {
    return new GroupServiceImpl(vertx);
  }

  static GroupService createProxy(Vertx vertx, String address) {
    return new GroupServiceVertxEBProxy(vertx, address);
  }

  void newGroup(
    NewGroup body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void getGroupById(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void updateGroupById(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void deleteGroupById(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void addUserToGroup(
    String id,
    String userId,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void deleteUserFromGroup(
    String id,
    String userId,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

}
