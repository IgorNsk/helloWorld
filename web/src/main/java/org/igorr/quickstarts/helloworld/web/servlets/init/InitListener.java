package org.igorr.quickstarts.helloworld.web.servlets.init;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
    private static final Logger LOG = LogManager.getLogger(InitListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("################################## INIT ##################################");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // do nothing
    }
}
