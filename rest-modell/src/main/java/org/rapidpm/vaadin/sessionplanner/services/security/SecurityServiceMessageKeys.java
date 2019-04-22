package org.rapidpm.vaadin.sessionplanner.services.security;

public enum SecurityServiceMessageKeys {

  SECURITYSERVICE_LOGIN_DENIED("securityservice.login.denied"),
  SECURITYSERVICE_USERNAME_AND_PASSWORD_NULL("securityservice.both.null"),
  SECURITYSERVICE_USERNAME_NULL("securityservice.username.null"),
  SECURITYSERVICE_USERNAME_IS_EMPTY("securityservice.username.is-empty"),
  SECURITYSERVICE_PASSWORD_NULL("securityservice.password.null"),
  SECURITYSERVICE_PASSWORD_IS_EMPTY("securityservice.password.is-empty");

  private String key;

  SecurityServiceMessageKeys(String key) {
    this.key = key;
  }

  public String key() {
    return this.key;
  }


}
