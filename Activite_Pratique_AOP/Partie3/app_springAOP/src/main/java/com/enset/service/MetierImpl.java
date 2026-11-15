package com.enset.service;

import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Override
    public void process() {
        System.out.println("Exécution de la méthode process() : Logique métier...");
    }

    @Override
    public double compute() {
        System.out.println("Exécution de la méthode compute() : Calcul en cours...");
        return 42.0;
    }
}