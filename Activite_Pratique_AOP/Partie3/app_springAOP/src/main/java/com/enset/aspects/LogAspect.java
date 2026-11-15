package com.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());


    @Around("execution(* com.enset.service..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("Début d'exécution de : " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        long t2 = System.currentTimeMillis();
        logger.info("Fin d'exécution. Durée : " + (t2 - t1) + " ms");
        return result;
    }
}