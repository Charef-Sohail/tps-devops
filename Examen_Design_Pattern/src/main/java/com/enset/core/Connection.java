package com.enset.core;

public class Connection {
    private double weight;
    private Neuron source;
    private Neuron destination;

    public Connection(double weight, Neuron source, Neuron destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public Neuron getSource() { return source; }
    public Neuron getDestination() { return destination; }
}