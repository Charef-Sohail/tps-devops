package com.enset.core;

import com.enset.observer.Observable;
import com.enset.observer.Observer;
import com.enset.state.ConstructionState;
import com.enset.state.State;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork implements Observable {
    private State state;
    private List<Layer> layers = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public NeuralNetwork() {
        this.state = new ConstructionState();
    }

    // --- Délégation au Pattern State ---

    public void changeState(State state) {
        this.state = state;
        notifyObservers();
    }

    public void train() {
        state.train(this);
    }

    public double[] predict(double[] inputs) {
        return state.predict(this, inputs);
    }

    public void fit() {
        state.fit(this);
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    // --- Implémentation du Pattern Observer ---

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
