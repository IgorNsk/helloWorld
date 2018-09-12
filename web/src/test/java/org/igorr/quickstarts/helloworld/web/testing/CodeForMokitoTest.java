package org.igorr.quickstarts.helloworld.web.testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnit44Runner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CodeForMokitoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void inc() {
        CodeForMokito c = new CodeForMokito();
        assertEquals(1, c.inc(0));
    }

    @Test
    public void dec() {
        CodeForMokito mock = mock(CodeForMokito.class);
        when(mock.dec(anyInt())).thenReturn(300);
        assertEquals(300, mock.dec(100));
    }
}