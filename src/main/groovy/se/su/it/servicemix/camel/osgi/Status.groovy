package se.su.it.servicemix.camel.osgi.status

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

public class Status {
    private static final transient Logger LOG = LoggerFactory.getLogger(this)

    @GET
    @Path("/status")
    @Produces(["text/html"])
    public Response status() {
        Response response
        def statusOutput = "Karaf Status: OK"
        statusOutput = statusOutput + "\n"
        response = Response.ok(statusOutput).status(Response.Status.OK).build()
        return response
    }

}
