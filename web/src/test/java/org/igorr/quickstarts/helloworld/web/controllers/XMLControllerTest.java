package org.igorr.quickstarts.helloworld.web.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class XMLControllerTest {

    XMLController controller;

    @Before
    public void setUp() throws Exception {
        controller = new XMLController();
    }

    @Test
    public void getCoffeeInXML() {
        Assert.assertNotSame(null, controller.getCoffeeInXML("test"));
    }
}