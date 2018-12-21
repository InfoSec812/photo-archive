package com.zanclus.photo.services.types;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;

@Data
@DataObject
public class ImageObject extends VertxDataObject {

    public ImageObject(JsonObject json) {
        ImageObject temp = Json.decodeValue(json.encode(), ImageObject.class);
    }

}