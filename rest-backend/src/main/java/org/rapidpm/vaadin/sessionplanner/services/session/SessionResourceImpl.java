package org.rapidpm.vaadin.sessionplanner.services.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.NotFoundException;
import org.rapidpm.vaadin.sessionplanner.services.OffsetRequest;

@RequestScoped
public class SessionResourceImpl implements SessionResource {
  private final List<Session> sessions;

  public SessionResourceImpl() {
    List<Session> sessions = new ArrayList<>();

    for (int i = 1; i < 200; i++) {
      Session session = new Session();
      session.setId(i);
      session.setTitle("Session - " + i);
      session.setAbstractText("#Session - " + i + "\n\nThis is about xyz");
      sessions.add(session);
    }
    this.sessions = Collections.unmodifiableList(sessions);
  }

  @Override
  public Session get(int id) {
    int i = id - 1;
    if (i >= 0 && i < sessions.size()) {
      return sessions.get(i);
    } else {
      throw new NotFoundException("No session with id " + id + " found.");
    }
  }

  @Override
  public List<SessionBase> find(SessionFilter filter, OffsetRequest offsetRequest) {
    Stream<? extends SessionBase> stream = sessions.stream().map(session -> {
      // In real world we would not load the abstract from prersistens layer
      SessionBase base = new SessionBase();
      base.setId(session.getId());
      base.setTitle(session.getTitle());
      return base;
    });
    stream = addFilter(filter, stream);
    stream = stream.skip(offsetRequest.getOffset()).limit(offsetRequest.getLimit());
    return stream.collect(Collectors.toList());
  }

  private Stream<? extends SessionBase> addFilter(SessionFilter filter,
      Stream<? extends SessionBase> stream) {
    if (filter.getNameContains() != null && !filter.getNameContains().equals("")) {
      stream = stream.filter(session -> session.getTitle().toLowerCase()
          .contains(filter.getNameContains().toLowerCase()));
    }
    return stream;
  }

  @Override
  public int count(SessionFilter filter) {
    return (int) addFilter(filter, sessions.stream()).count();
  }
}
