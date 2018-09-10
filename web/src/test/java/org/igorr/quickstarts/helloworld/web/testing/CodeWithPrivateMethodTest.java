package org.igorr.quickstarts.helloworld.web.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
    }

    @Test(expected = RuntimeException.class)
    public void when_gambling_is_true_then_always_explode() throws Exception {
        CodeWithPrivateMethod spy = PowerMockito.spy(new CodeWithPrivateMethod());

        when(spy, method(CodeWithPrivateMethod.class, "doTheGamble", String.class, int.class))
                .withArguments(anyString(), anyInt())
                .thenReturn(true);

        spy.meaningfulPublicApi();
    }
}