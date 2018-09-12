package org.igorr.quickstarts.helloworld.web.testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * https://www.baeldung.com/powermock-private-method
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(LuckyNumberGenerator.class)
public class LuckyNumberGeneratorTest {

    private LuckyNumberGenerator mock = spy(new LuckyNumberGenerator());

    @Before
    public void setUp() {

    }




    @Test
    public void getLuckyNumberDefault() throws Exception {
        when(mock, "getDefaultLuckyNumber").thenReturn(300);
        assertEquals(300,  mock.getLuckyNumber(null));
    }

    @Test
    public void getLuckyNumberComputed() throws Exception {
        when(mock, "getComputedLuckyNumber", anyInt()).thenReturn(300);
        assertEquals(300,  mock.getLuckyNumber("Name"));
    }

    @Test
    public void getLuckyNumber() {
        LuckyNumberGenerator g = new LuckyNumberGenerator();
        assertEquals(10, g.getLuckyNumber("1234567890"));

    }
}