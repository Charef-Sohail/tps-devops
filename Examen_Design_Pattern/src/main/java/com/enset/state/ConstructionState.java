package com.enset.state;

import com.enset.core.NeuralNetwork;

public class ConstructionState implements State {
    @Override
    public void train(NeuralNetwork nn) {
        System.out.println("Début de l'entraînement... Passage à l'état TRAINING.");
        nn.changeState(new TrainingState());

        // Simulation de l'entraînement
        System.out.println("... Calcul des poids en cours ...");

        // Fin de l'entraînement
        System.out.println("Entraînement terminé. Passage à l'état TRAINED.");
        nn.changeState(new TrainedState());
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] inputs) {
        throw new RuntimeException("Erreur : Impossible de prédire. Le réseau est en construction et n'est pas entraîné !");
    }

    @Override
    public void fit(NeuralNetwork nn) {
        System.out.println("Appel de fit() : Passage à l'état d'exécution.");
    }
}
