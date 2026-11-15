package com.enset.core;

import com.enset.activation.ActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private ActivationFunction activationFunction;
    private List<Connection> inputs = new ArrayList<>();
    private List<Connection> outputs = new ArrayList<>();
    private double outputValue; // Stocke la sortie (Y) du neurone

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void addInputConnection(Connection c) { inputs.add(c); }
    public void addOutputConnection(Connection c) { outputs.add(c); }

    public double getOutputValue() { return outputValue; }
    public void setOutputValue(double outputValue) { this.outputValue = outputValue; } // Utile pour la couche d'entrée

    public void calculate() {
        double sum = 0;
        for (Connection c : inputs) {
            // Xi * Wi
            sum += c.getSource().getOutputValue() * c.getWeight();
        }
        // Applique la fonction d'activation
        this.outputValue = activationFunction.activate(sum);
    }
}