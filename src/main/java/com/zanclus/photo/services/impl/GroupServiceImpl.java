package com.zanclus.photo.services.impl;

import com.zanclus.photo.services.GroupService;
import com.zanclus.photo.services.types.Group;
import com.zanclus.photo.services.types.NewGroup;

import org.apache.commons.lang3.NotImplementedException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

public class GroupServiceImpl implements GroupService {

  private final JsonObject config;

  private final Vertx vertx;

  public GroupServiceImpl(io.vertx.core.Vertx vertx, JsonObject config) {
    this.config = config;
    this.vertx = Vertx.newInstance(vertx);
  }

  @Override
  public void newGroup(NewGroup newGroup, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void getGroupById(String groupId, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void updateGroupById(Group group, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void addUserToGroup(String id, String userId, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void deleteUserFromGroup(String id, String userId, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void deleteGroupById(String id, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }
}