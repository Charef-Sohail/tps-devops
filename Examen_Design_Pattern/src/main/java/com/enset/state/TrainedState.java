package com.enset.state;

import com.enset.core.NeuralNetwork;

public class TrainedState implements State {
    @Override
    public void train(NeuralNetwork nn) {
        System.out.println("Le réseau est déjà entraîné. Voulez-vous réinitialiser ?");
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] inputs) {
        System.out.println("Prédiction en cours avec les entrées fournies...");
        return new double[]{0.95, 0.05};
    }

    @Override
    public void fit(NeuralNetwork nn) {
        System.out.println("Action impossible. Le réseau est déjà entraîné.");
    }
}