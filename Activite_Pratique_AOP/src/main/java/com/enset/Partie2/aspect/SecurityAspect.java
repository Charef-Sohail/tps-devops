package com.enset.Partie2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* com.enset.Partie2.test.Application.start(..))")
    public void startApp() { }

    @Around("startApp()")
    public void securiser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== AUTHENTIFICATION (Aspect Sécurité) ======");
        System.out.print("Username : ");
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();

        if (username.equals("root") && password.equals("1234")) {
            System.out.println("Accès autorisé.");
            proceedingJoinPoint.proceed();
        } else {
            System.out.println("Accès refusé ! Mauvais identifiants.");
        }
    }
}