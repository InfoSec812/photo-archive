package com.zanclus.photo.types;

import java.time.Instant;
import java.util.List;

import lombok.Data;

@Data
public class Group extends NewGroup {

  private String id;

  private Instant created;

  private Instant modified;

  private List<String> members;
}