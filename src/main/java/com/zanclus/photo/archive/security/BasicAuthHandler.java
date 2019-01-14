package com.zanclus.photo.archive.security;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class BasicAuthHandler implements Handler<RoutingContext> {

    public BasicAuthHandler(){

    }

    @Override
    public void handle(RoutingContext routingContext) {
        // Handle  security schema
        routingContext.next();
    }

}