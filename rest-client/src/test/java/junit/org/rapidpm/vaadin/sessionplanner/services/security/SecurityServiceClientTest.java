package junit.org.rapidpm.vaadin.sessionplanner.services.security;

import junit.org.rapidpm.vaadin.sessionplanner.ServiceEndpointExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rapidpm.vaadin.sessionplanner.services.security.SecurityServiceClient;

import java.util.function.Consumer;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(ServiceEndpointExtension.class)
class SecurityServiceClientTest {


  //TODO PageObject -> SecurityServiceClient -> dynamic Port
  @Test void test001() {
    new SecurityServiceClient()
        .checkLogin("admin", "admin")
        .ifPresentOrElse(user -> assertAll(() -> assertEquals("Jon Doe", user.username()),
                                           () -> assertTrue(now().isAfter(user.loginTimestamp()))),
                         (Consumer<String>) Assertions::fail);

  }
}
