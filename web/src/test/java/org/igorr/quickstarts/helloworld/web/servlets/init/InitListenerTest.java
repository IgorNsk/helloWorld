package org.igorr.quickstarts.helloworld.web.servlets.init;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletContextEvent;

import static org.junit.Assert.*;

public class InitListenerTest {

    private InitListener listener;
    private ServletContextEvent contextEvent;

    @Before
    public void setUp() throws Exception {
        listener = new InitListener();
    }

    @Test
    public void contextInitialized() {
        listener.contextInitialized(contextEvent);
    }

    @Test
    public void contextDestroyed() {
    }
}