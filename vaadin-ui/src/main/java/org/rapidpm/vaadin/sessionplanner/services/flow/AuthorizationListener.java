package org.rapidpm.vaadin.sessionplanner.services.flow;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.ListenerPriority;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.UIInitEvent;
import com.vaadin.flow.server.UIInitListener;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.rapidpm.dependencies.core.logger.HasLogger;

@ListenerPriority(Integer.MAX_VALUE - 1)
public class AuthorizationListener implements VaadinServiceInitListener, UIInitListener, BeforeEnterListener, HasLogger {
  @Override
  public void beforeEnter(BeforeEnterEvent event) {

  }

  @Override
  public void uiInit(UIInitEvent event) {

  }

  @Override
  public void serviceInit(ServiceInitEvent event) {

  }
}
