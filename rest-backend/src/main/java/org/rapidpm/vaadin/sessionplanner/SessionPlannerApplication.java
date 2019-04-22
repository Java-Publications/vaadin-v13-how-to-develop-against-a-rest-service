package org.rapidpm.vaadin.sessionplanner;

import org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceResource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;
import static org.rapidpm.vaadin.sessionplanner.SessionPlannerApplication.*;

@ApplicationScoped
@ApplicationPath(APPLICATION_ROOT)
public class SessionPlannerApplication extends Application {

  public static final String APPLICATION_ROOT = "/";

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> set = new HashSet<>();
    set.add(SecurityServiceResource.class);
    return unmodifiableSet(set);
  }

}
