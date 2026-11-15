package com.enset.service;

import com.enset.aspects.Log;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Override
    @Log
    public void process() {
        System.out.println("Exécution de la méthode process() : Logique métier...");
    }

    @Override
    @Log
    public double compute() {
        System.out.println("Exécution de la méthode compute() : Calcul en cours...");
        return 42.0;
    }
}