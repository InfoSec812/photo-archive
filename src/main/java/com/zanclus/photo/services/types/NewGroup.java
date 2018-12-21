package com.zanclus.photo.services.types;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;

@Data
@DataObject
public class NewGroup extends VertxDataObject {

  private String name;

  private String description;

  public NewGroup() {
    super();
  }

  public NewGroup(JsonObject json) {
    NewGroup temp = Json.decodeValue(json.encode(), NewGroup.class);
    this.description = temp.description;
    this.name = temp.name;
  }
}