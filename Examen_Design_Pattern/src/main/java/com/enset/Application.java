package com.enset;

import com.enset.activation.Sigmoid;
import com.enset.aspects.SecurityContext;
import com.enset.core.*;
import com.enset.observer.Dashboard;

public class Application {
    public static void main(String[] args) {
        System.out.println("=== 1. INITIALISATION DU RÉSEAU ===");
        NeuralNetwork nn = new NeuralNetwork();

        // Attachement du Dashboard (Observer Pattern)
        Dashboard dashboard = new Dashboard();
        nn.attach(dashboard);

        // Création de l'architecture
        InputLayer inputLayer = new InputLayer();
        HiddenLayer hiddenLayer = new HiddenLayer();
        OutputLayer outputLayer = new OutputLayer();

        Neuron n1 = new Neuron();
        n1.setActivationFunction(new Sigmoid()); // Application du Strategy Pattern
        hiddenLayer.addNeuron(n1);

        nn.addLayer(inputLayer);
        nn.addLayer(hiddenLayer);
        nn.addLayer(outputLayer);

        System.out.println("\n=== 2. TENTATIVE D'ENTRAÎNEMENT (SANS DROITS) ===");
        try {
            nn.train();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 3. AUTHENTIFICATION ADMIN ===");
        SecurityContext.authenticate("root", "1234", "ADMIN");

        System.out.println("\n=== 4. ENTRAÎNEMENT ET PRÉDICTION ===");
        nn.train();

        double[] inputs = {0.5, 0.8};
        nn.predict(inputs);
    }
}
