package org.rapidpm.vaadin.sessionplanner.services.security;


import org.rapidpm.frp.model.Result;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.rapidpm.vaadin.sessionplanner.services.security.SecurityServicePaths.LOGIN;

public class SecurityServiceClient implements SecurityServiceAPI {

  private static final UserConverter USER_CONVERTER = new UserConverter();
  private static final Client        CLIENT         = ClientBuilder.newClient();

  @Override public Result<User> checkLogin(String username, String password) {

    WebTarget webResource = CLIENT.target("http://localhost:8080"   //TODO should come from outside
                                          + LOGIN + "/" + username + "/" + password);

    String response = webResource.request(APPLICATION_JSON).buildGet()
                                            .invoke(String.class);

    return USER_CONVERTER.fromJSON(response);
  }
}
