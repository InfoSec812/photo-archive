package com.zanclus.photo.securityHandlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class ApiKeyAuthSecurityHandler implements Handler<RoutingContext> {

    public ApiKeyAuthSecurityHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle ApiKeyAuth security schema
        routingContext.next();
    }

}