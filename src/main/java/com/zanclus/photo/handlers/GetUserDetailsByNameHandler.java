package com.zanclus.photo.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.ext.web.RoutingContext;

public class GetUserDetailsByNameHandler implements Handler<RoutingContext> {

    public GetUserDetailsByNameHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        RequestParameters params = routingContext.get("parsedParameters");
        // Handle getUserDetailsByName
        routingContext.response().setStatusCode(501).setStatusMessage("Not Implemented").end();
    }

}