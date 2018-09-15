package org.igorr.quickstarts.helloworld.beans.services.messages;

import org.apache.log4j.Logger;
import org.igorr.quickstarts.helloworld.beans.services.util.ApiService;
import org.igorr.quickstarts.helloworld.beans.services.util.BarApiServiceImpl;
import org.igorr.quickstarts.helloworld.beans.services.util.FooApiServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MessageServiceImplTest {
    @Mock
    Logger LOG;
    @InjectMocks
    MessageServiceImpl messageServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShow() throws Exception {
        messageServiceImpl.show();
    }

    @Test
    public void testFooCall() throws Exception{
        ApiService api = new FooApiServiceImpl();
        messageServiceImpl.call(api);
    }

    @Test
    public void testBarCall() throws Exception{
        ApiService api = new BarApiServiceImpl();
        messageServiceImpl.call(api);
    }

    @Test
    public void testGetMessage() throws Exception {
        String result = messageServiceImpl.getMessage();
        //Assert.assertEquals("ErrorMessage::error", result);
        Assert.assertNotSame(null, result);
    }

    @Test
    public void testDestroy() throws Exception {
        messageServiceImpl.destroy();
    }

    @Test
    public void testAfterPropertiesSet() throws Exception {
        messageServiceImpl.afterPropertiesSet();
    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme