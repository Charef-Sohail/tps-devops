package com.enset.activation;

public class Identity implements ActivationFunction {
    @Override
    public double activate(double s) {
        return s;
    }
}