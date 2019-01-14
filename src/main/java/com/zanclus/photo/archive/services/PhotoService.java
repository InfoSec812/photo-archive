package com.zanclus.photo.archive.services;

import com.zanclus.photo.archive.models.ImageObject;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.*;
import io.vertx.ext.web.api.generator.WebApiServiceGen;

import java.util.List;
import java.util.Map;

import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.services.impl.PhotoServiceImpl;

@WebApiServiceGen
@ProxyGen
public interface PhotoService {

  static PhotoService create(Vertx vertx) {
    return new PhotoServiceImpl(vertx);
  }

  static PhotoService createProxy(Vertx vertx, String address) {
    return new PhotoServiceVertxEBProxy(vertx, address);
  }

  void addPhoto(
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void getImageById(
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void updateImageById(
    String id,
    ImageObject body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void deleteImageById(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void getTagsByPhotoId(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void addTagToPhoto(
    String id,
    String tag,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

  void deleteTagFromPhoto(
    String id,
    String tag,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler);

}
