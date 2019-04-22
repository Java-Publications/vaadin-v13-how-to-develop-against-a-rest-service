package org.rapidpm.vaadin.sessionplanner.services.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.rapidpm.frp.model.serial.Pair;

import java.time.LocalDateTime;

public class User extends Pair<String, LocalDateTime> {

  public static final String NAME = "name";
  public static final String TIMESTAMP = "timestamp";

  @JsonCreator
  public User(
      @JsonProperty(NAME)  String name,
      @JsonProperty(TIMESTAMP) LocalDateTime timestamp) {
    super(name, timestamp);
  }

  public String username() {
    return getT1();
  }

  public LocalDateTime loginTimestamp() {
    return getT2();
  }
}
