package org.rapidpm.vaadin.sessionplanner.services.security;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.time.LocalDateTime.now;
import static org.rapidpm.vaadin.sessionplanner.services.security.SecurityServicePaths.LOGIN;


@Path(LOGIN)
@RequestScoped
public class SecurityServiceResource {

  public static final String        ANONYMOUS     = "anonymous";
  private             UserConverter userConverter = new UserConverter();

  @Inject private SecurityService securityService;


  @GET
  @Path("{user}/{password}")
  @Produces(MediaType.APPLICATION_JSON)
  public String login(@PathParam("user") final String user,
                      @PathParam("password") final String password) {
    return securityService
        .checkLogin(user, password)
        .flatMap(u -> userConverter.toJSON(u))
        .getOrElse(() -> userConverter
            .toJSON(new User(ANONYMOUS, now()))
            .get());
  }

}
