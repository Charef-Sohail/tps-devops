package com.enset.state;

import com.enset.core.NeuralNetwork;

public class TrainingState implements State {
    @Override
    public void train(NeuralNetwork nn) {
        System.out.println("Le réseau est déjà en cours d'entraînement !");
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] inputs) {
        throw new RuntimeException("Erreur : Le réseau est en plein entraînement. Prédiction impossible.");
    }

    @Override
    public void fit(NeuralNetwork nn) {
        System.out.println("Action impossible en mode Training.");
    }
}
