package se.su.it.servicemix.camel.osgi.status

import org.apache.camel.builder.RouteBuilder;

public class StatusRoutes extends RouteBuilder {

  public void configure() throws Exception {

    from("cxfrs://?resourceClass=se.su.it.servicemix.camel.osgi.status.Status")
      .beanRef("Status", "status")
      .to("log:FAX");

  }

}
