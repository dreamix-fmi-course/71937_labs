package com.fmi.web.theaterticketsystem.model;

public class User {
  private Long id;
  private String userName;
  private String email;

  // works when using post request - deserialization :)
  public User(Long id, String userName, String email) {
    this.id = id;
    this.userName = userName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
