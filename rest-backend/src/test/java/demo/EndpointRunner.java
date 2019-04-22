package demo;

import io.helidon.microprofile.server.Server;

public class EndpointRunner {

  private EndpointRunner() {
  }

  public static void main(String[] args) {
//    WebServer webServer = null;
//    try {
//      webServer = WebServer
//          .create(Routing
//                      .builder()
//                      .any(LOGIN, (req, res) -> res.send("ask for login"))
//                      .any((req, res) -> res.send("It works!"))
//                      .build())
//          .start()
//          .toCompletableFuture()
//          .get(10, TimeUnit.SECONDS);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    } catch (ExecutionException e) {
//      e.printStackTrace();
//    } catch (TimeoutException e) {
//      e.printStackTrace();
//    }


    Server webServer = Server
        .create()
        .start();

    System.out.println("Server started at: http://" + webServer.host() + ":" + webServer.port());
  }
}
