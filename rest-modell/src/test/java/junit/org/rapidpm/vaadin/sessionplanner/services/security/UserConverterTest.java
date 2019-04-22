package junit.org.rapidpm.vaadin.sessionplanner.services.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.rapidpm.vaadin.sessionplanner.services.security.User;
import org.rapidpm.vaadin.sessionplanner.services.security.UserConverter;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserConverterTest {


  @Test void test001(TestReporter reporter) {

    LocalDateTime timestamp = LocalDateTime.now();
    User          user      = new User("Hans", timestamp);

    new UserConverter()
        .toJSON(user)
        .ifFailed(Assertions::fail)
        .ifPresent(reporter::publishEntry)
        .map(json -> new UserConverter().fromJSON(json))
        .ifPresentOrElse(fromJson -> assertEquals(user, fromJson.get()),
                         (Consumer<String>) Assertions::fail);
  }
}
