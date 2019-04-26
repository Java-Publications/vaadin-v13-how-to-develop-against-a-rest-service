package org.rapidpm.vaadin.sessionplanner.services.flow;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.UIInitListener;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.shared.Registration;
import org.rapidpm.dependencies.core.logger.HasLogger;

public class ApplicationServiceInitListener
    implements VaadinServiceInitListener, HasLogger {


  @Override
  public void serviceInit(ServiceInitEvent e) {

    e.getSource().addUIInitListener((UIInitListener) uiInitEvent -> {
      UI ui = uiInitEvent.getUI();
      logger().info("init LoginListener for .. " + ui);
      Registration loginRegistration = ui.addBeforeEnterListener(new LoginListener());

    });
  }



}
