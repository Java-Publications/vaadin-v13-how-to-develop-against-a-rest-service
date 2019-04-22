package org.rapidpm.vaadin.sessionplanner.services.security;

import org.rapidpm.frp.model.Result;

import javax.enterprise.context.ApplicationScoped;

import static java.time.LocalDateTime.now;
import static org.rapidpm.frp.matcher.Case.match;
import static org.rapidpm.frp.matcher.Case.matchCase;
import static org.rapidpm.frp.model.Result.failure;
import static org.rapidpm.frp.model.Result.success;
import static org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceMessageKeys.*;

@ApplicationScoped
public class SecurityService implements SecurityServiceAPI {


  //#3 TODO Connection to a persistence Layer
  public Result<User> checkLogin(String username, String password) {
    return match(matchCase(() -> failure(SECURITYSERVICE_LOGIN_DENIED.key())),
                 matchCase(() -> username == null && password == null,
                           () -> failure(SECURITYSERVICE_USERNAME_AND_PASSWORD_NULL.key())),
                 matchCase(() -> username == null,
                           () -> failure(SECURITYSERVICE_USERNAME_NULL.key())),
                 matchCase(username::isEmpty,
                           () -> failure(SECURITYSERVICE_USERNAME_IS_EMPTY.key())),
                 matchCase(() -> password == null,
                           () -> failure(SECURITYSERVICE_PASSWORD_NULL.key())),
                 matchCase(password::isEmpty,
                           () -> failure(SECURITYSERVICE_PASSWORD_IS_EMPTY.key())),
                 matchCase(() -> username.equals("admin") && password.equals("admin"),
                           () -> success(new User("Jon Doe", now()))
                          )
                );
  }

}
