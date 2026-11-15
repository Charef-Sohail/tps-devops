package com.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* com.enset.core.NeuralNetwork.train(..))")
    public void secureTrain() { }

    @Around("secureTrain()")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP Sécurité : Vérification des droits pour " + joinPoint.getSignature().getName() + "()...");

        if (SecurityContext.hasRole("ADMIN")) {
            System.out.println("AOP Sécurité : Accès autorisé.");
            return joinPoint.proceed();
        } else {
            throw new RuntimeException("AOP Sécurité : Accès refusé ! Vous devez être ADMIN pour entraîner le réseau.");
        }
    }
}