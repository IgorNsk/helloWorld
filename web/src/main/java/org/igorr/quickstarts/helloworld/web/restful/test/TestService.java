package org.igorr.quickstarts.helloworld.web.restful.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.igorr.quickstarts.helloworld.web.annotations.Trace;
import org.igorr.quickstarts.helloworld.web.restful.BasicRestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by IgorR on 06.10.16.
 */

@Path("/")
public class TestService extends BasicRestService {

    private static final Log LOG = LogFactory.getLog(TestService.class);

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response call(@PathParam("code") String num, @Context javax.servlet.http.HttpServletRequest request) {
        LOG.debug("call makeResponse()");
        return makeResponse(num, "0", "false", request);
    }

    @Trace(level = "debug")
    private Response makeResponse(String cqNum, String filter, String debug, javax.servlet.http.HttpServletRequest request) {

        LOG.info("makeResponse");

        try {
            String message = generateMessage();
            return Response.ok(message, MediaType.TEXT_PLAIN + "; charset=utf-8").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage(), "application/json; charset=utf-8").build();
        }
    }


}
