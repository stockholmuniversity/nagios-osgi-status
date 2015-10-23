package se.su.it.servicemix.camel.osgi

import org.apache.camel.builder.RouteBuilder;

public class StatusRoutes extends RouteBuilder {

  public void configure() throws Exception {

    from("restlet:/status?restletMethod=GET")
      .bean("Status", "status")
      .to("log:FAX");

  }

}
