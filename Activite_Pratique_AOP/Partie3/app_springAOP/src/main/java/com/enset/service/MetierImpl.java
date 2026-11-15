package com.enset.service;

import com.enset.aspects.Log;
import com.enset.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Override
    @Log
    @SecuredByAspect(roles = {"USER", "ADMIN"})
    public void process() {
        System.out.println("Exécution de la méthode process() : Logique métier...");
    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        System.out.println("Exécution de la méthode compute() : Calcul en cours...");
        return 42.0;
    }
}