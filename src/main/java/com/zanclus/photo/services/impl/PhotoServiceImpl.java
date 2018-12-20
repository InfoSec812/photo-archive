package com.zanclus.photo.services.impl;

import com.zanclus.photo.services.PhotoService;
import com.zanclus.photo.types.ImageObject;

import org.apache.commons.lang3.NotImplementedException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

public class PhotoServiceImpl implements PhotoService {

  private final JsonObject config;
  private final Vertx vertx;

  public PhotoServiceImpl(io.vertx.core.Vertx vertx, JsonObject config) {
    this.config = config;
    this.vertx = Vertx.newInstance(vertx);
  }

  @Override
  public void addPhoto(Buffer imageData, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void getImageById(String id, Handler<AsyncResult<Buffer>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void updateImageById(ImageObject imageData, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void deleteImageById(String id, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void getTagsByPhotoId(String id, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void addTagToPhoto(String id, String tag, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }

  @Override
  public void deleteTagFromPhoto(String id, String tag, Handler<AsyncResult<JsonObject>> handler) {
    handler.handle(Future.failedFuture(new NotImplementedException("Method not yet implemented")));
  }
}