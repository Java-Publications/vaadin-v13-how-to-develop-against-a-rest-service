package org.rapidpm.vaadin.sessionplanner.services.security;


import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.frp.model.Result;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.rapidpm.vaadin.sessionplanner.services.security.SecurityServicePaths.LOGIN;

public class SecurityServiceClient implements SecurityServiceAPI, HasLogger {

  private static final UserConverter USER_CONVERTER = new UserConverter();
  private static final Client        CLIENT         = ClientBuilder.newClient();

  @Override
  public Result<User> checkLogin(String username, String password) {

    WebTarget webResource = CLIENT.target("http://localhost:8080"   //TODO should come from outside
                                          + LOGIN + "/" + username + "/" + password);

    Response response = webResource
        .request(APPLICATION_JSON)
        .buildGet()
        .invoke();

    Response.StatusType statusInfo = response.getStatusInfo();
    Response.Status     status     = statusInfo.toEnum();
    switch (status) {
      case OK:
        return USER_CONVERTER.fromJSON(response.readEntity(String.class));
      default: {
        String statusInfoReasonPhrase = statusInfo.getReasonPhrase();
        int    statusCode             = statusInfo.getStatusCode();
        logger().warning(" -- " + statusCode + " -- " + statusInfoReasonPhrase);
        throw new RuntimeException("LOGIN Failed for " + username);
      }
    }
  }
}
