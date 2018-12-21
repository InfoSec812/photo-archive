package com.zanclus.photo.services.types;

import java.time.Instant;
import java.util.List;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@DataObject
@EqualsAndHashCode(callSuper = false)
public class Group extends NewGroup {

  private String id;

  private Instant created;

  private Instant modified;

  private List<String> members;

  public Group(JsonObject json) {
    Group temp = Json.decodeValue(json.encode(), Group.class);
    this.id = temp.id;
    this.created = temp.created;
    this.modified = temp.modified;
    this.members = temp.members;
    this.setName(temp.getName());
  }
}