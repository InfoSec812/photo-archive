package com.zanclus.photo.services.types;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class VertxDataObject {

    public JsonObject toJson() {
        return new JsonObject(Json.encode(this));
    }
}
