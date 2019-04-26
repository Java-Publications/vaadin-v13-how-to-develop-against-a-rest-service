package org.rapidpm.vaadin.sessionplanner.services.session;

import org.rapidpm.vaadin.sessionplanner.services.session.modell.OffsetRequest;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.Session;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionBase;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionFilter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(SessionServiceAPI.PATH)
@Produces(MediaType.APPLICATION_JSON)
public interface SessionServiceAPI {

  String PATH_COUNT = "count";
  String PATH = "sessions";

  @GET
  @Path("{id}")
  Session get(@PathParam("id") int id);

  @GET
  List<SessionBase> find(@BeanParam SessionFilter filter,
                         @BeanParam OffsetRequest offsetRequest);

  @GET
  @Path(PATH_COUNT)
  long count(@BeanParam SessionFilter filter);
}
