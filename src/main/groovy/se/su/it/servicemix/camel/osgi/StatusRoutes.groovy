package se.su.it.servicemix.camel.osgi

import org.apache.camel.builder.RouteBuilder;

public class StatusRoutes extends RouteBuilder {

  public void configure() throws Exception {

    from("restlet:/status?restletMethods=GET,POST")
    // This works, but starts another HTTP server...
    // We want to use the already existing Jetty
    // from("restlet:http://localhost:8080/status?restletMethods=GET,POST")
      .beanRef("Status", "status")
      .to("log:FAX");

  }

}
