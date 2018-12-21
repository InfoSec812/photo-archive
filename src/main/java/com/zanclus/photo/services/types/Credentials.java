package com.zanclus.photo.services.types;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;

@Data
@DataObject
public class Credentials extends VertxDataObject {
  private final String username;

  private final String password;

  public Credentials(JsonObject json) {
      Credentials temp = Json.decodeValue(json.encode(), Credentials.class);
      this.username = temp.username;
      this.password = temp.password;
  }
}