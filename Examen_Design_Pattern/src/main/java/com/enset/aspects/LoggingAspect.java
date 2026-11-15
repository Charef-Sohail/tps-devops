package com.enset.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.enset.core..*(..))")
    public void allCoreMethods() { }

    @Around("allCoreMethods()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        logger.info("AOP Log - Exécution de " + joinPoint.getSignature().getName() + "() | Durée : " + (end - start) + "ms");

        return result;
    }
}