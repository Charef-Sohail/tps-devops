package com.enset.Partie2.aspect;

import com.enset.Partie2.metier.Compte;
import com.enset.Partie2.metier.MetierImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {

    // Cible uniquement la méthode retirer et capture ses arguments (code et montant)
    @Pointcut("execution(* com.enset.Partie2.metier.MetierImpl.retirer(..)) && args(code, montant)")
    public void pcRetrait(Long code, double montant) { }

    @Around("pcRetrait(code, montant)")
    public Object patchRetrait(ProceedingJoinPoint proceedingJoinPoint, Long code, double montant) throws Throwable {

        MetierImpl metier = (MetierImpl) proceedingJoinPoint.getTarget();
        Compte compte = metier.consulter(code);
        if (compte.getSolde() < montant) {
            throw new RuntimeException("Patch AOP : Solde insuffisant pour ce retrait !");
        }
        return proceedingJoinPoint.proceed();
    }
}