package org.igorr.quickstarts.helloworld.tests.hamcrests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ClassForMatcherTestsTest {

    private ClassForMatcherTests mt;

    @Before
    public void setUp() throws Exception {
        mt = new ClassForMatcherTests();
    }

    @Test
    public void incTest() {
        //assertEquals(1, mt.inc(0));
        Integer i = mt.inc(0);
        assertThat("qqqq", i != null);
    }

    @Test
    public void inc2Test(){
        Integer i = mt.inc(true);
        assertThat("qqqq", i != null);
        assertThat(1, is(equalTo(1)));
    }

    @Test
    public void inc3Test(){
        Integer i = mt.inc(false);
        assertThat("qqqq", i == null);
    }

    @Test(expected = RuntimeException.class)
    public void getFlagTest() throws Exception {

        ClassForMatcherTests spy = PowerMockito.spy(new ClassForMatcherTests());

        when(spy, MemberMatcher.method(ClassForMatcherTests.class, "isFlag"))
                .withNoArguments()
                .thenReturn(false);

        spy.getFlag();
    }

    @Test
    public void listShouldInitiallyBeEmpty() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, hasSize(3));

        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));

        assertThat(list, containsInAnyOrder(2, 4, 5));

        assertThat(list, everyItem(greaterThan(1)));

    }
}