package org.igorr.quickstarts.helloworld.web.servlets.login;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletConfig;
import java.util.ResourceBundle;

public class LoginServletTest {
    @Mock
    Logger LOG;
    @Mock
    ResourceBundle lStrings;
    @Mock
    ServletConfig config;
    @InjectMocks
    LoginServlet loginServlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws Exception {
        loginServlet.doGet(null, null);
    }

    @Test
    public void testDoPost() throws Exception {
        loginServlet.doPost(null, null);
    }

    @Test
    public void testGetServletInfo() throws Exception {
        String result = loginServlet.getServletInfo();
        Assert.assertEquals("Short description", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme