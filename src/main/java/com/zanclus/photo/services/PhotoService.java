package com.zanclus.photo.services;

import com.zanclus.photo.services.impl.PhotoServiceImpl;
import com.zanclus.photo.services.types.ImageObject;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

/**
 * The service proxy implementation of the Photo service
 *
 * NOTE: The {@link #addPhoto} method and the {@link #getImageById} cannot directly return
 * a {@link Buffer} due to limitations of a Service Proxy. The implementing code will
 * have to handle the binary read and response.
 */
@ProxyGen
@VertxGen
public interface PhotoService {

  static PhotoService create(Vertx vertx) {
    return new PhotoServiceImpl(vertx, vertx.getOrCreateContext().config());
  }

  static PhotoService createProxy(Vertx vertx, String address) {
    return new PhotoServiceVertxEBProxy(vertx, address);
  }

  /**
   * Add a new photo to storage
   * @param imageData The image metadata
   * @param handler The callback handler
   */
  void addPhoto(ImageObject imageData, Handler<AsyncResult<JsonObject>> handler);

  void getImageById(String id, Handler<AsyncResult<JsonObject>> handler);

  void updateImageById(ImageObject imageData, Handler<AsyncResult<JsonObject>> handler);

  void deleteImageById(String id, Handler<AsyncResult<JsonObject>> handler);

  void getTagsByPhotoId(String id, Handler<AsyncResult<JsonObject>> handler);

  void addTagToPhoto(String id, String tag, Handler<AsyncResult<JsonObject>> handler);

  void deleteTagFromPhoto(String id, String tag, Handler<AsyncResult<JsonObject>> handler);
}