package com.enset.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    protected List<Neuron> neurons = new ArrayList<>();

    public void addNeuron(Neuron n) {
        neurons.add(n);
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }
}