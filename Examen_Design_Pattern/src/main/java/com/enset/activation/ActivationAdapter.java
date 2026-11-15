package com.enset.activation;

public class ActivationAdapter implements ActivationFunction {
    private OldActivationFunction oldFunction;

    public ActivationAdapter(OldActivationFunction oldFunction) {
        this.oldFunction = oldFunction;
    }

    @Override
    public double activate(double s) {
        return oldFunction.computeOldActivation(s);
    }
}