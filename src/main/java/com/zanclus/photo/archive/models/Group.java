package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;
import java.util.List;

@DataObject(generateConverter = true, publicConverter = false)
public class Group {

  private String name;
  private String description;
  private String id;
  private String created;
  private String modified;
  private List<User> members;

  public Group (
    String name,
    String description,
    String id,
    String created,
    String modified,
    List<User> members
  ) {
    this.name = name;
    this.description = description;
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.members = members;
  }

  public Group(JsonObject json) {
    GroupConverter.fromJson(json, this);
  }

  public Group(Group other) {
    this.name = other.getName();
    this.description = other.getDescription();
    this.id = other.getId();
    this.created = other.getCreated();
    this.modified = other.getModified();
    this.members = other.getMembers();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    GroupConverter.toJson(this, json);
    return json;
  }

  @Fluent public Group setName(String name){
    this.name = name;
    return this;
  }
  public String getName() {
    return this.name;
  }

  @Fluent public Group setDescription(String description){
    this.description = description;
    return this;
  }
  public String getDescription() {
    return this.description;
  }

  @Fluent public Group setId(String id){
    this.id = id;
    return this;
  }
  public String getId() {
    return this.id;
  }

  @Fluent public Group setCreated(String created){
    this.created = created;
    return this;
  }
  public String getCreated() {
    return this.created;
  }

  @Fluent public Group setModified(String modified){
    this.modified = modified;
    return this;
  }
  public String getModified() {
    return this.modified;
  }

  @Fluent public Group setMembers(List<User> members){
    this.members = members;
    return this;
  }
  public List<User> getMembers() {
    return this.members;
  }

}