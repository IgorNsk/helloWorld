package org.igorr.quickstarts.helloworld.web.restful;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;

public class BasicRestServiceTest {

    @Mock
    HttpServletRequest request;

    @InjectMocks
    BasicRestService basicRestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetUserFromRequest() throws Exception {
        HttpSession httpSession = mock(HttpSession.class);
        PowerMockito.when(request.getSession()).thenReturn(httpSession);
        PowerMockito.when(httpSession.getAttribute(any(String.class))).thenReturn(Boolean.TRUE);
        Boolean result = basicRestService.getUserFromRequest(request);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testGenerateMessage() throws Exception {
        String result = basicRestService.generateMessage();
        Assert.assertEquals("ErrorMessage::error", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme