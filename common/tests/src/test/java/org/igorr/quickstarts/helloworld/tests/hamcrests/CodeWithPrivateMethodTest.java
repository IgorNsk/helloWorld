package org.igorr.quickstarts.helloworld.tests.hamcrests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;


/**
 * https://stackoverflow.com/questions/7803944/how-to-mock-private-method-for-testing-using-powermock
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(CodeWithPrivateMethod.class)
public class CodeWithPrivateMethodTest {

    @Test
    public void meaningfulPublicApi() {
        CodeWithPrivateMethod code = new CodeWithPrivateMethod();
        code.meaningfulPublicApi();
    }

    @Test(expected = RuntimeException.class)
    public void when_gambling_is_true_then_always_explode() throws Exception {
        CodeWithPrivateMethod spy = PowerMockito.spy(new CodeWithPrivateMethod());

        when(spy, MemberMatcher.method(CodeWithPrivateMethod.class, "doTheGamble", String.class, int.class))
                .withArguments(any(String.class), any(Integer.class))
                .thenReturn(true);

        spy.meaningfulPublicApi();
    }
}