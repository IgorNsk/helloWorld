package org.igorr.quickstarts.helloworld.web.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.igorr.quickstarts.helloworld.web.annotations.Trace;

import java.util.Arrays;

@Aspect
public class WebServiceLogger {
    private static final Logger LOG = Logger.getLogger(WebServiceLogger.class);

    @Pointcut("execution(* org.igorr.quickstarts.helloworld.web.restful.hello.HelloService.*(..))")
    public void webServiceMethod() {
        // Do nothing because of aspect.
    }


    @Pointcut("@annotation(annotationTrace)")
    public void webServiceMethodAnnotation(Trace annotationTrace){
        // Do nothing because of aspect.
    }


    @Around("webServiceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        LOG.debug("Call before method " + methodName + " with args " + Arrays.toString(methodArgs));

        Object result = thisJoinPoint.proceed();

        LOG.debug("Method " + methodName + " returns " + result);

        return result;
    }

    @Before("webServiceMethodAnnotation(annotationTrace)")
    public void annotationWebServiceCall(Trace annotationTrace){
        LOG.debug("annotation level: " + annotationTrace.level());
    }

}
