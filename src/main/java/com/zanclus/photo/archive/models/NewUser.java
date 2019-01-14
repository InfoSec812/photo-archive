package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
public class NewUser {

  private String username;
  private String email;
  private String password;
  private String familyName;
  private String givenName;

  public NewUser (
    String username,
    String email,
    String password,
    String familyName,
    String givenName
  ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.familyName = familyName;
    this.givenName = givenName;
  }

  public NewUser(JsonObject json) {
    NewUserConverter.fromJson(json, this);
  }

  public NewUser(NewUser other) {
    this.username = other.getUsername();
    this.email = other.getEmail();
    this.password = other.getPassword();
    this.familyName = other.getFamilyName();
    this.givenName = other.getGivenName();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    NewUserConverter.toJson(this, json);
    return json;
  }

  @Fluent public NewUser setUsername(String username){
    this.username = username;
    return this;
  }
  public String getUsername() {
    return this.username;
  }

  @Fluent public NewUser setEmail(String email){
    this.email = email;
    return this;
  }
  public String getEmail() {
    return this.email;
  }

  @Fluent public NewUser setPassword(String password){
    this.password = password;
    return this;
  }
  public String getPassword() {
    return this.password;
  }

  @Fluent public NewUser setFamilyName(String familyName){
    this.familyName = familyName;
    return this;
  }
  public String getFamilyName() {
    return this.familyName;
  }

  @Fluent public NewUser setGivenName(String givenName){
    this.givenName = givenName;
    return this;
  }
  public String getGivenName() {
    return this.givenName;
  }

}