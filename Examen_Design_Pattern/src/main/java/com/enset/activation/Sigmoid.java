package com.enset.activation;

public class Sigmoid implements ActivationFunction {
    @Override
    public double activate(double s) {
        return 1.0 / (1.0 + Math.exp(-s));
    }
}