package org.igorr.quickstarts.helloworld.web.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WebServiceTrace {
    private static final Logger LOG = Logger.getLogger(WebServiceTrace.class);

    @Pointcut("execution(* org.igorr.quickstarts.helloworld.web.restful.hello.HelloService.*(..))")
    public void webServiceMethod() {
        // Do nothing because of aspect.
    }


    @Around("webServiceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        LOG.debug("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        LOG.debug("Method " + methodName + " returns " + result);

        return result;
    }
}
