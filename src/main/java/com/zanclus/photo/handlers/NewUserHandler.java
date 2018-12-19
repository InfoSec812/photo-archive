package com.zanclus.photo.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.ext.web.RoutingContext;

public class NewUserHandler implements Handler<RoutingContext> {

    public NewUserHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        RequestParameters params = routingContext.get("parsedParameters");
        // Handle newUser
        routingContext.response().setStatusCode(501).setStatusMessage("Not Implemented").end();
    }

}