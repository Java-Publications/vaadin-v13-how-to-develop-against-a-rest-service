package org.rapidpm.vaadin.sessionplanner.services.flow;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.server.VaadinSession;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.frp.model.Result;
import org.rapidpm.vaadin.demo.views.Home;
import org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceClient;
import org.rapidpm.vaadin.sessionplanner.services.security.User;

import static org.rapidpm.frp.model.Result.ofNullable;

class LoginListener
    implements BeforeEnterListener, HasLogger {

  private static final SecurityServiceClient securityService = new SecurityServiceClient();

  @Override
  public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
    final UI            ui            = UI.getCurrent();
    final VaadinSession vaadinSession = ui.getSession();

    Result<User> result = ofNullable(vaadinSession.getAttribute(User.class));

    result.ifPresentOrElse(u -> logger().info("User is logged in : " + u),
                           failed -> {
      logger().info("Anonymous User: redirecting to Login View");

      LoginOverlay component = new LoginOverlay();

      component.addLoginListener(
          e -> ofNullable(securityService.checkLogin(e.getUsername(), e.getPassword())).ifPresentOrElse(u -> {
            component.setError(false);
            component.setOpened(false);
            UI.getCurrent()
              .getSession()
              .setAttribute(User.class, u);
            UI.getCurrent()
              .navigate(Home.class);
          }, f -> {
            component.setError(true);
            component.setDescription(ui.getTranslation("securityservice.login.denied"));
            logger().info(f);
          }));

      LoginI18n i18n = LoginI18n.createDefault();
      i18n.setAdditionalInformation(ui.getTranslation("login.additional.info"));
      component.setI18n(i18n);
      component.setOpened(true);
    });

  }
}
