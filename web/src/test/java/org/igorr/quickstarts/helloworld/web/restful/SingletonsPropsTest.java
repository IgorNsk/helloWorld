package org.igorr.quickstarts.helloworld.web.restful;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SingletonsPropsTest {

    @Test
    public void testGetProps() throws Exception {
        Set<Object> result = SingletonsProps.getProps();
        Assert.assertNotEquals( null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme