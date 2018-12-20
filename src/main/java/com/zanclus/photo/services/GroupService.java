package com.zanclus.photo.services;

import com.zanclus.photo.services.impl.GroupServiceImpl;
import com.zanclus.photo.types.Group;
import com.zanclus.photo.types.NewGroup;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

@ProxyGen
@VertxGen
public interface GroupService {

  static GroupService create(io.vertx.core.Vertx vertx) {
    return new GroupServiceImpl(vertx, vertx.getOrCreateContext().config());
  }

  static GroupService createProxy(io.vertx.core.Vertx vertx, String address) {
    return new GroupServiceVertxEBProxy(vertx, address);
  }

  void newGroup(NewGroup newGroup, Handler<AsyncResult<JsonObject>> handler);

  void getGroupById(String groupId, Handler<AsyncResult<JsonObject>> handler);

  void updateGroupById(Group group, Handler<AsyncResult<JsonObject>> handler);

  void addUserToGroup(String id, String userId, Handler<AsyncResult<JsonObject>> handler);

  void deleteUserFromGroup(String id, String userId, Handler<AsyncResult<JsonObject>> handler);

  void deleteGroupById(String id, Handler<AsyncResult<JsonObject>> handler);
}