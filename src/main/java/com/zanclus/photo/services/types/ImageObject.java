package com.zanclus.photo.services.types;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;
import lombok.experimental.Delegate;

@Data
@DataObject
public class ImageObject extends VertxDataObject {

    @Delegate(types = com.google.schemaorg.core.ImageObject.class)
    com.google.schemaorg.core.ImageObject instance;

    public ImageObject(JsonObject json) {
        ImageObject temp = Json.decodeValue(json.encode(), ImageObject.class);
    }
}