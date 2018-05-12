package org.igorr.quickstarts.helloworld.web.restful.hello;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Response.class, HelloService.class})
public class HelloServiceTest {
    @Mock
    Log LOG;

    @InjectMocks
    //@Spy
    HelloService helloService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        //mockStatic(Response.class);
        //PowerMockito.when(Response.ok(any(Object.class),any(String.class)).build()).thenReturn(null);

    }

    @Test
    public void testResponse() throws Exception {
        mockStatic(Response.class);
        Response.ResponseBuilder responseBuilder = mock(Response.ResponseBuilder.class);
        Response response = mock(Response.class);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class))).thenReturn(responseBuilder);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class)).build()).thenReturn(response);
        String message = "message-for-test";
        Response.ok(message, MediaType.TEXT_PLAIN + "; charset=utf-8").build();
    }

    @Test
    public void testFixCqAllTasks() throws Exception {
        mockStatic(Response.class);
        Response.ResponseBuilder responseBuilder = mock(Response.ResponseBuilder.class);
        Response response = mock(Response.class);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class))).thenReturn(responseBuilder);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class)).build()).thenReturn(null);

        Response result = helloService.fixCqAllTasks("num", null);
        Assert.assertEquals(null, result);
    }

    @Test(expected = NullPointerException.class)
    public void testErrorFixCqAllTasks() throws Exception {
        mockStatic(Response.class);
        Response.ResponseBuilder responseBuilder = mock(Response.ResponseBuilder.class);
        Response response = mock(Response.class);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class))).thenReturn(null);
        PowerMockito.when(Response.ok(any(Object.class),any(String.class)).build()).thenReturn(null);

        Response result = helloService.fixCqAllTasks("num", null);
        Assert.assertEquals(null, result);
    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme