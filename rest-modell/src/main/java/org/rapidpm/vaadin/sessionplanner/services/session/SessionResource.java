package org.rapidpm.vaadin.sessionplanner.services.session;

import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.rapidpm.vaadin.sessionplanner.services.OffsetRequest;

@Path("sessions")
@Produces(MediaType.APPLICATION_JSON)
public interface SessionResource {

  @GET
  @Path("{id}")
  public Session get(@PathParam("id") int id);

  @GET
  public List<SessionBase> find(@BeanParam SessionFilter filter,
      @BeanParam OffsetRequest offsetRequest);
  
  @GET
  @Path("count")
  public int count(@BeanParam SessionFilter filter);
}
