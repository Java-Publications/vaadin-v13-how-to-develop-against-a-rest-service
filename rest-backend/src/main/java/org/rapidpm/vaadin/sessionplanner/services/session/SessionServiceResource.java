package org.rapidpm.vaadin.sessionplanner.services.session;

import org.rapidpm.vaadin.sessionplanner.services.session.modell.OffsetRequest;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.Session;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionBase;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionFilter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
public class SessionServiceResource
    implements SessionServiceAPI {

  @Inject private SessionRepository sessionRepository;

  @Override
  public Session get(int id) {
    try {
      return sessionRepository.get(id);
    } catch (Exception e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<SessionBase> find(SessionFilter filter,
                                OffsetRequest offsetRequest) {
    return sessionRepository.find(filter, offsetRequest);
  }


  @Override
  public long count(SessionFilter filter) {
    return sessionRepository.count(filter);
  }
}
