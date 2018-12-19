package com.zanclus.photo.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.ext.web.RoutingContext;

public class GetImageByIdHandler implements Handler<RoutingContext> {

    public GetImageByIdHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle getImageById
        routingContext.response().setStatusCode(501).setStatusMessage("Not Implemented").end();
    }

}