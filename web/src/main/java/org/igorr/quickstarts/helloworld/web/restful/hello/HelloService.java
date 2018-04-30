package org.igorr.quickstarts.helloworld.web.restful.hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.igorr.quickstarts.helloworld.beans.BeansConfiguration;
import org.igorr.quickstarts.helloworld.beans.services.messages.MessageService;
import org.igorr.quickstarts.helloworld.web.annotations.Trace;
import org.igorr.quickstarts.helloworld.web.restful.BasicRestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by IgorR on 06.10.16.
 */

@Path("/")
public class HelloService extends BasicRestService {

    private static final Log LOG = LogFactory.getLog(HelloService.class);

    @GET
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fixCqAllTasks(@PathParam("num") String num, @Context javax.servlet.http.HttpServletRequest request) {
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

    private String generateMessage() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        MessageService messageService = context.getBean(MessageService.class);
        String msg = messageService.getMessage();
        context.registerShutdownHook();
        Optional<String> msgObj = Optional.ofNullable(msg);

        return msgObj.orElse("Ошибка при получении сообщения");

    }
}
