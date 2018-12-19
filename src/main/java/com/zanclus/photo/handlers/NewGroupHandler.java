package com.zanclus.photo.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.ext.web.RoutingContext;

public class NewGroupHandler implements Handler<RoutingContext> {

    public NewGroupHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        RequestParameters params = routingContext.get("parsedParameters");
        // Handle newGroup
        routingContext.response().setStatusCode(501).setStatusMessage("Not Implemented").end();
    }

}