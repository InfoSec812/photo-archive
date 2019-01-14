package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
public class Error {

  private Integer code;
  private String message;

  public Error (
    Integer code,
    String message
  ) {
    this.code = code;
    this.message = message;
  }

  public Error(JsonObject json) {
    ErrorConverter.fromJson(json, this);
  }

  public Error(Error other) {
    this.code = other.getCode();
    this.message = other.getMessage();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    ErrorConverter.toJson(this, json);
    return json;
  }

  @Fluent public Error setCode(Integer code){
    this.code = code;
    return this;
  }
  public Integer getCode() {
    return this.code;
  }

  @Fluent public Error setMessage(String message){
    this.message = message;
    return this;
  }
  public String getMessage() {
    return this.message;
  }

}