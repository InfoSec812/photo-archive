package com.zanclus.photo.securityHandlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class BearerAuthSecurityHandler implements Handler<RoutingContext> {

    public BearerAuthSecurityHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle BearerAuth security schema
        routingContext.next();
    }

}