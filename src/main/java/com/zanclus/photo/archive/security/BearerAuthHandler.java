package com.zanclus.photo.archive.security;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class BearerAuthHandler implements Handler<RoutingContext> {

    public BearerAuthHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle  security schema
        routingContext.next();
    }

}