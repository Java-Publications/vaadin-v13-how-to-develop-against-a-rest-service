package org.rapidpm.vaadin.sessionplanner.services.security;


import org.rapidpm.dependencies.core.logger.HasLogger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class SecurityServiceClient
    implements SecurityServiceAPI, HasLogger {

  private static final Client CLIENT = ClientBuilder.newClient();

  @Override
  public User checkLogin(String username, String password) {

    WebTarget webResource = CLIENT.target("http://localhost:8080"   //TODO should come from outside
                                          + LOGIN + "/" + username + "/" + password);

    Response response = webResource.request(APPLICATION_JSON)
                                   .buildGet()
                                   .invoke();

    Response.StatusType statusInfo = response.getStatusInfo();
    Response.Status     status     = statusInfo.toEnum();
    switch (status) {
      case OK:
        return response.readEntity(User.class);
      default: {
        String statusInfoReasonPhrase = statusInfo.getReasonPhrase();
        int    statusCode             = statusInfo.getStatusCode();
        logger().warning(" -- " + statusCode + " -- " + statusInfoReasonPhrase);
//        return Result.failure("login failed");
        return null; //FUCKING NULL
      }
    }
  }
}
