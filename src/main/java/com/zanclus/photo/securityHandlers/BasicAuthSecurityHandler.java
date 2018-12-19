package com.zanclus.photo.securityHandlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class BasicAuthSecurityHandler implements Handler<RoutingContext> {

    public BasicAuthSecurityHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle BasicAuth security schema
        routingContext.next();
    }

}