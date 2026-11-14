package com.enset.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {

    // Définition du Pointcut
    @Pointcut("execution(* com.enset.test.Application.main(..))")
    public void pc1() {
    }

//    // Exécution AVANT la méthode ciblée
//    @Before("pc1()")
//    public void beforeMain() {
//        System.out.println("before main class syntax");
//    }
//
//    // Exécution APRÈS la méthode ciblée
//    @After("pc1()")
//    public void afterMain() {
//        System.out.println("after main class syntax");
//    }
//
    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before main class syntax");

        proceedingJoinPoint.proceed();

        System.out.println("after main class syntax");
    }

}
