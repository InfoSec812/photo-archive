package com.zanclus.photo.archive.services.impl;

import com.zanclus.photo.archive.models.ImageObject;
import com.zanclus.photo.archive.services.PhotoService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.api.*;

import java.util.List;
import java.util.Map;

import com.zanclus.photo.archive.models.*;
import com.zanclus.photo.archive.services.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhotoServiceImpl implements PhotoService {

  private static final Logger LOG = LoggerFactory.getLogger(PhotoServiceImpl.class);

  private Vertx vertx;

  public PhotoServiceImpl(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public void addPhoto(
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){

    LOG.info(context.getExtra().encodePrettily());

    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void getImageById(
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void updateImageById(
    String id,
    ImageObject body,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void deleteImageById(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void getTagsByPhotoId(
    String id,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void addTagToPhoto(
    String id,
    String tag,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

  @Override
  public void deleteTagFromPhoto(
    String id,
    String tag,
    OperationRequest context, Handler<AsyncResult<OperationResponse>> resultHandler){
    // Write your business logic here
    resultHandler.handle(Future.succeededFuture(new OperationResponse().setStatusCode(501).setStatusMessage("Not Implemented")));
  }

}
