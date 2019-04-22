package org.rapidpm.vaadin.sessionplanner.services.security;

import org.rapidpm.frp.functions.CheckedFunction;
import org.rapidpm.frp.model.Result;
import org.rapidpm.vaadin.sessionplanner.services.JACKSONModellConverter;

public class UserConverter extends JACKSONModellConverter<User> {

  @Override public Result<User> fromJSON(String json) {
    return ((CheckedFunction<String, User>) s -> mapper().readValue(s, User.class)).apply(json);

  }

  @Override public Result<String> toJSON(User value) {
    return ((CheckedFunction<User, String>) u -> mapper().writeValueAsString(u)).apply(value);
  }

}
