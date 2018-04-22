package org.igorr.quickstarts.helloworld.beans.aspect;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {

    private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* org.igorr.quickstarts.helloworld.beans.services.starter.GreetingService.sayGreeting(..))")
    public void logBefore(JoinPoint joinPoint) {

        LOG.info("logBefore() is running!");
        String methodName = joinPoint.getSignature().getName();
        LOG.info("hijacked : " + methodName);
        Object[] methodArgs = joinPoint.getArgs();
        LOG.info("Call annotation method " + methodName + " with args " + methodArgs);
        LOG.info("******");
    }
}
