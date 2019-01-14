package com.zanclus.photo.archive.security;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class ApiKeyAuthHandler implements Handler<RoutingContext> {

    public ApiKeyAuthHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle X-API-Key security schema
        routingContext.next();
    }

}