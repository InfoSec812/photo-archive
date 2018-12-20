package com.zanclus.photo.types;

import java.time.Instant;

import lombok.Data;

@Data
public class User extends NewUser {

  public String id;

  public Instant created;

  public Instant modified;
}