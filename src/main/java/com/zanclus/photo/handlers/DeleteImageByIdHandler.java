package com.zanclus.photo.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.ext.web.RoutingContext;

public class DeleteImageByIdHandler implements Handler<RoutingContext> {

    public DeleteImageByIdHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        RequestParameters params = routingContext.get("parsedParameters");
        // Handle deleteImageById
        routingContext.response().setStatusCode(501).setStatusMessage("Not Implemented").end();
    }

}