package org.igorr.quickstarts.helloworld.beans;

import org.igorr.quickstarts.helloworld.beans.services.messages.MessageService;
import org.igorr.quickstarts.helloworld.beans.services.starter.BeanWithDependency;
import org.igorr.quickstarts.helloworld.beans.services.starter.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnotherConfigurationTest {
    @Mock
    GreetingService greetingService;
    @Mock
    MessageService showService;
    @InjectMocks
    AnotherConfiguration anotherConfiguration;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBeanWithDependency() throws Exception {
        BeanWithDependency result = anotherConfiguration.beanWithDependency();
        //Assert.assertEquals(new BeanWithDependency(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme