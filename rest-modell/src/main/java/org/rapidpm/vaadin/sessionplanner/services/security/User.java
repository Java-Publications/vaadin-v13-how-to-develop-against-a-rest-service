package org.rapidpm.vaadin.sessionplanner.services.security;

import java.time.LocalDateTime;

public class User {

  private String name;
  private LocalDateTime timestamp;


  public User() {
  }

  public User(String name, LocalDateTime timestamp) {
    super();
    this.name = name;
    this.timestamp = timestamp;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
