package org.igorr.quickstarts.helloworld.web.restful;

import org.igorr.quickstarts.helloworld.beans.BeansConfiguration;
import org.igorr.quickstarts.helloworld.beans.services.messages.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class BasicRestService {
    public static final String LDAP_USED_PARAMETER = "ldapUsed";
    protected Boolean getUserFromRequest(HttpServletRequest request) {
        return (Boolean) request.getSession().getAttribute(LDAP_USED_PARAMETER);
    }
    protected String generateMessage() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        MessageService messageService = context.getBean(MessageService.class);
        String msg = messageService.getMessage();
        context.registerShutdownHook();
        Optional<String> msgObj = Optional.ofNullable(msg);

        return msgObj.orElse("Ошибка при получении сообщения");

    }
}
