package org.rapidpm.vaadin.sessionplanner.services.security;


import org.rapidpm.dependencies.core.logger.HasLogger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RequestScoped
public class SecurityServiceResource
    implements SecurityServiceAPI, HasLogger {

  @Inject private SecurityService securityService;

  @GET
  @Path("{user}/{password}")
  public User checkLogin(@PathParam("user") final String user, @PathParam("password") final String password) {
    return securityService.checkLogin(user, password)
//                          .flatMap(u -> userConverter.toJSON(u))
                          .ifFailed((failed) -> logger().info("bad username/password combination for user " + user))
                          .ifFailed((failed) -> {
                            throw new RuntimeException(failed);
                          })
                          .get(); //
  }


}

