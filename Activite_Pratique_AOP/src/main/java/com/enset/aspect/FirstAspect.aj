package com.enset.aspect;

public aspect FirstAspect {
// Définition du Pointcut (la cible)
    pointcut pc1() : execution(* com.enset.test.Application.main(..));
//
//    // Exécution AVANT la méthode ciblée
//    before() : pc1() {
//        System.out.println("before main from aspect j syntax");
//    }
//
//    // Exécution APRÈS la méthode ciblée
//    after() : pc1() {
//        System.out.println("after main from aspect j syntax");
//    }

    // Autour de la méthode ciblée
    void around() : pc1() {
        System.out.println("before");
        proceed();
        System.out.println("after");
    }
}