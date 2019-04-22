package junit.org.rapidpm.vaadin.sessionplanner;

import io.helidon.microprofile.server.Server;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.create;

public class ServiceEndpointExtension implements BeforeEachCallback, AfterEachCallback {


  public static final String    REST_SERVER = "rest-server";
  public static final Namespace NAME_SPACE  = create(REST_SERVER);


  @Override public void afterEach(ExtensionContext extensionContext) throws Exception {
    Server server = extensionContext
        .getStore(NAME_SPACE)
        .get(REST_SERVER, Server.class);
    if(server != null) server.stop();
  }

  @Override public void beforeEach(ExtensionContext extensionContext) throws Exception {

    Server webServer = Server
        .create()
        .start();

    extensionContext
        .getStore(NAME_SPACE)
        .put(REST_SERVER, webServer);

  }
}
