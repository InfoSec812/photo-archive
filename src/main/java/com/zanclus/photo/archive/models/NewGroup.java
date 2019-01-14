package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
public class NewGroup {

  private String name;
  private String description;

  public NewGroup (
    String name,
    String description
  ) {
    this.name = name;
    this.description = description;
  }

  public NewGroup(JsonObject json) {
    NewGroupConverter.fromJson(json, this);
  }

  public NewGroup(NewGroup other) {
    this.name = other.getName();
    this.description = other.getDescription();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    NewGroupConverter.toJson(this, json);
    return json;
  }

  @Fluent public NewGroup setName(String name){
    this.name = name;
    return this;
  }
  public String getName() {
    return this.name;
  }

  @Fluent public NewGroup setDescription(String description){
    this.description = description;
    return this;
  }
  public String getDescription() {
    return this.description;
  }

}