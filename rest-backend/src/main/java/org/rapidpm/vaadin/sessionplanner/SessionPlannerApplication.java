package org.rapidpm.vaadin.sessionplanner;

import static java.util.Collections.unmodifiableSet;
import static org.rapidpm.vaadin.sessionplanner.SessionPlannerApplication.APPLICATION_ROOT;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceResource;
import org.rapidpm.vaadin.sessionplanner.services.session.SessionResourceImpl;

@ApplicationScoped
@ApplicationPath(APPLICATION_ROOT)
public class SessionPlannerApplication extends Application {

  public static final String APPLICATION_ROOT = "/";

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> set = new HashSet<>();
    set.add(SecurityServiceResource.class);
    set.add(SessionResourceImpl.class);
    return unmodifiableSet(set);
  }

}
