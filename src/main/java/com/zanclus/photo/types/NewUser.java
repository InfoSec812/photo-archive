package com.zanclus.photo.types;

import lombok.Data;

@Data
public class NewUser {

  private String username;

  private String password;

  private String givenName;

  private String familyName;

  private String email;
}