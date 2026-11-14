package com.enset.Partie2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LogAspect {

    private Logger logger = Logger.getLogger(LogAspect.class.getName());
    public LogAspect() throws IOException{
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    // Cible toutes les méthodes de toutes les classes du package 'metier'
    @Pointcut("execution(* com.enset.Partie2.metier.*.*(..))")
    public void pc1() { }

    @Around("pc1()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("Avant l'exécution de la méthode : " + proceedingJoinPoint.getSignature());

        Object result = proceedingJoinPoint.proceed();

        long t2 = System.currentTimeMillis();
        logger.info("Après l'exécution de la méthode : " + proceedingJoinPoint.getSignature());
        logger.info("Durée d'exécution : " + (t2 - t1) + " ms");
        logger.info("--------------------------------------------------");

        return result;
    }
}