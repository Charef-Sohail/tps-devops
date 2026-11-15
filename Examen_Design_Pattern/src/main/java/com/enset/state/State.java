package com.enset.state;

import com.enset.core.NeuralNetwork;

public interface State {
    void train(NeuralNetwork nn);
    double[] predict(NeuralNetwork nn, double[] inputs);
    void fit(NeuralNetwork nn);
}
