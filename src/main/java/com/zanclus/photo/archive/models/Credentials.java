package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
public class Credentials {

  private String username;
  private String password;

  public Credentials (
    String username,
    String password
  ) {
    this.username = username;
    this.password = password;
  }

  public Credentials(JsonObject json) {
    CredentialsConverter.fromJson(json, this);
  }

  public Credentials(Credentials other) {
    this.username = other.getUsername();
    this.password = other.getPassword();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    CredentialsConverter.toJson(this, json);
    return json;
  }

  @Fluent public Credentials setUsername(String username){
    this.username = username;
    return this;
  }
  public String getUsername() {
    return this.username;
  }

  @Fluent public Credentials setPassword(String password){
    this.password = password;
    return this;
  }
  public String getPassword() {
    return this.password;
  }

}