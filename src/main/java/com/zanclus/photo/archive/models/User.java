package com.zanclus.photo.archive.models;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.core.json.JsonObject;
import java.util.List;

@DataObject(generateConverter = true, publicConverter = false)
public class User {

  private String username;
  private String email;
  private String password;
  private String familyName;
  private String givenName;
  private Integer id;
  private String created;
  private String modified;
  private List<Group> groups;

  public User (
    String username,
    String email,
    String password,
    String familyName,
    String givenName,
    Integer id,
    String created,
    String modified,
    List<Group> groups
  ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.familyName = familyName;
    this.givenName = givenName;
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.groups = groups;
  }

  public User(JsonObject json) {
    UserConverter.fromJson(json, this);
  }

  public User(User other) {
    this.username = other.getUsername();
    this.email = other.getEmail();
    this.password = other.getPassword();
    this.familyName = other.getFamilyName();
    this.givenName = other.getGivenName();
    this.id = other.getId();
    this.created = other.getCreated();
    this.modified = other.getModified();
    this.groups = other.getGroups();
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    UserConverter.toJson(this, json);
    return json;
  }

  @Fluent public User setUsername(String username){
    this.username = username;
    return this;
  }
  public String getUsername() {
    return this.username;
  }

  @Fluent public User setEmail(String email){
    this.email = email;
    return this;
  }
  public String getEmail() {
    return this.email;
  }

  @Fluent public User setPassword(String password){
    this.password = password;
    return this;
  }
  public String getPassword() {
    return this.password;
  }

  @Fluent public User setFamilyName(String familyName){
    this.familyName = familyName;
    return this;
  }
  public String getFamilyName() {
    return this.familyName;
  }

  @Fluent public User setGivenName(String givenName){
    this.givenName = givenName;
    return this;
  }
  public String getGivenName() {
    return this.givenName;
  }

  @Fluent public User setId(Integer id){
    this.id = id;
    return this;
  }
  public Integer getId() {
    return this.id;
  }

  @Fluent public User setCreated(String created){
    this.created = created;
    return this;
  }
  public String getCreated() {
    return this.created;
  }

  @Fluent public User setModified(String modified){
    this.modified = modified;
    return this;
  }
  public String getModified() {
    return this.modified;
  }

  @Fluent public User setGroups(List<Group> groups){
    this.groups = groups;
    return this;
  }
  public List<Group> getGroups() {
    return this.groups;
  }

}