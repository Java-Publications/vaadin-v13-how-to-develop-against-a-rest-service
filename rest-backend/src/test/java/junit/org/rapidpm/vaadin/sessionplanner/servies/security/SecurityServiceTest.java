package junit.org.rapidpm.vaadin.sessionplanner.servies.security;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rapidpm.vaadin.sessionplanner.services.security.SecurityService;

import static org.junit.jupiter.api.Assertions.fail;

public class SecurityServiceTest {


  @Disabled
  @Test void test001() {
    SecurityService service = new SecurityService();
    service
        .checkLogin(null, null)
        .ifPresentOrElse(ok -> fail("should not work"),
                         failed -> {});
  }

  @Test void test002() {
    SecurityService service = new SecurityService();
    service
        .checkLogin("", "")
        .ifPresentOrElse(ok -> fail("should not work"),
                         failed -> {});
  }

  @Test void test003() {
    SecurityService service = new SecurityService();
    service
        .checkLogin("X", "")
        .ifPresentOrElse(ok -> fail("should not work"),
                         failed -> {});
  }

  @Test void test004() {
    SecurityService service = new SecurityService();
    service
        .checkLogin("", "x")
        .ifPresentOrElse(ok -> fail("should not work"),
                         failed -> {});
  }


  //only for demo
  @DisplayName("FOR DEMO ONLY")
  @Test void test005() {
    SecurityService service = new SecurityService();
    service
        .checkLogin("admin", "admin")
        .ifPresentOrElse(ok -> {},
                         failed -> fail("should not work"));
  }
}
