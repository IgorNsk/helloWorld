package org.igorr.quickstarts.helloworld.beans.services.messages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.igorr.quickstarts.helloworld.beans.generics.MessageManager;
import org.igorr.quickstarts.helloworld.beans.generics.MessageManagerImpl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("messageService")
@Scope("prototype")
@Qualifier("main")
public class MessageServiceImpl implements MessageService, InitializingBean, DisposableBean {
    private static final Logger LOG = LogManager.getLogger(MessageServiceImpl.class);

    @Override
    public void show() {
        MessageManager manager = new MessageManagerImpl();
        Message message = manager.get(() ->
                new ErrorMessage("qqqqq")
        );
        LOG.debug(message.get().toString());
    }

    @Override
    public String getMessage() {
        int ch = random();
        MessageManager manager = new MessageManagerImpl();
        Message msg;
        if (ch == 0) {
            msg = manager.get(() ->
                    new SuccessMessage("success")
            );
        } else {
            msg = manager.get(() ->
                    new ErrorMessage("error")
            );
        }
        return msg.get().getMessage();
    }

    private int random() {
        Random r = new Random();
        return r.nextInt(2);
    }

    @Override
    public void destroy() throws Exception {
        LOG.debug("call destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.debug("call afterPropertiesSet()");
    }
}
