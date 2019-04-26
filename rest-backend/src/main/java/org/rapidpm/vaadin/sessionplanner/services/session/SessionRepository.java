package org.rapidpm.vaadin.sessionplanner.services.session;

import org.rapidpm.vaadin.sessionplanner.services.session.modell.OffsetRequest;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.Session;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionBase;
import org.rapidpm.vaadin.sessionplanner.services.session.modell.SessionFilter;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@ApplicationScoped
public class SessionRepository {

  private final Map<Integer, Session> sessions = IntStream.range(1, 200)
                                                          .mapToObj(i -> {
                                                            Session session = new Session();
                                                            session.setId(i);
                                                            session.setTitle("Session - " + i);
                                                            session.setAbstractText(
                                                                "#Session - " + i + "\n\nThis is about xyz");
                                                            return session;
                                                          })
                                                          .collect(toMap(Session::getId, e -> e));

  public Session get(int id) {
    if (sessions.containsKey(id)) {
      return sessions.get(id);
    } else {
      throw new RuntimeException("No session with id " + id + " found.");
    }
  }


  private static Function<String, Predicate<Session>> filter() {
    return (nameContains) -> (nameContains != null && !nameContains.isEmpty())
                             ? (s) -> s.getTitle()
                                       .toLowerCase()
                                       .contains(nameContains.toLowerCase())
                             : (s) -> true;
  }

  public List<SessionBase> find(SessionFilter filter, OffsetRequest offsetRequest) {
    return sessions.values()
                   .stream()
                   .filter(filter().apply(filter.getNameContains()))
                   .map(session -> {
                     // In real world we would not load
                     // the abstract from persistens layer
                     SessionBase base = new SessionBase();
                     base.setId(session.getId());
                     base.setTitle(session.getTitle());
                     return base;
                   })
                   .skip(offsetRequest.getOffset())
                   .limit(offsetRequest.getLimit())
                   .collect(toList());
  }


  public long count(SessionFilter filter) {
    return sessions.values()
                   .stream()
                   .filter(filter().apply(filter.getNameContains()))
                   .count();
  }

}
