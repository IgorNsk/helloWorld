package org.igorr.quickstarts.helloworld.web.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.igorr.quickstarts.helloworld.web.annotations.Trace;

@Aspect
public class WebServiceTrace {
    private static final Logger LOG = Logger.getLogger(WebServiceTrace.class);

    @Pointcut("execution(* org.igorr.quickstarts.helloworld.web.restful.hello.HelloService.*(..))")
    public void webServiceMethod() {
        // Do nothing because of aspect.
    }


    @Pointcut("@annotation(annotationTrace)")
    public void webServiceMethodDebug(Trace annotationTrace){
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


    @Around("webServiceMethodDebug(annotationTrace)")
    public Object debugWebServiceCall(Trace annotationTrace, ProceedingJoinPoint thisJoinPoint) throws Throwable {

        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();


        LOG.debug("Call DEBUG method " + methodName + " with args " + methodArgs);
        LOG.debug("Trace.level(): " + annotationTrace.level());

        Object result = thisJoinPoint.proceed();
        return result;

    }

}
