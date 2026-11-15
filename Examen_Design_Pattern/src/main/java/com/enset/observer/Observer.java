package com.enset.observer;

import com.enset.core.NeuralNetwork;

public interface Observer {
    void update(NeuralNetwork nn);
}
