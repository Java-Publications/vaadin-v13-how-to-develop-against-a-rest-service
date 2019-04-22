package org.rapidpm.vaadin.sessionplanner.services.security;

import org.rapidpm.frp.model.Result;

public interface SecurityServiceAPI {

  Result<User> checkLogin(String username, String password);


}
