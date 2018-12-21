package com.zanclus.photo.services.types;

import java.time.Instant;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@DataObject
@EqualsAndHashCode(callSuper = false)
public class User extends NewUser {

  public String id;

  public Instant created;

  public Instant modified;

  public User(JsonObject json) {
    User temp = Json.decodeValue(json.encode(), User.class);
    this.setEmail(temp.getEmail());
    this.setFamilyName(temp.getFamilyName());
    this.setGivenName(temp.getGivenName());
    this.setPassword(temp.getPassword());
    this.setUsername(temp.getUsername());
    this.id = temp.id;
    this.created = temp.created;
    this.modified = temp.modified;
  }
}