package org.rapidpm.vaadin.sessionplanner.services.security;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceAPI.LOGIN;

@Path(LOGIN)
@Produces(MediaType.APPLICATION_JSON)
public interface SecurityServiceAPI {

  String LOGIN = "/login";

  @GET
  @Path("{user}/{password}")
  User checkLogin(@PathParam("user") final String user, @PathParam("password") final String password);


}
