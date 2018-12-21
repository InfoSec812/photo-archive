package com.zanclus.photo.services.types;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;

@Data
@DataObject
public class NewUser extends VertxDataObject {

  private String username;

  private String password;

  private String givenName;

  private String familyName;

  private String email;

  public NewUser() {
    super();
  }

  public NewUser(JsonObject json) {
    NewUser temp = Json.decodeValue(json.encode(), NewUser.class);
    this.email = temp.email;
    this.familyName = temp.familyName;
    this.givenName = temp.familyName;
    this.password = temp.password;
    this.username = temp.username;
  }
}