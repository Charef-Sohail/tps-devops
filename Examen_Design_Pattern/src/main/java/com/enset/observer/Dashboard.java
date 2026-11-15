package com.enset.observer;

import com.enset.core.NeuralNetwork;

public class Dashboard implements Observer {
    @Override
    public void update(NeuralNetwork nn) {
        System.out.println("Dashboard : Notification reçue ! Le réseau de neurones a changé d'état.");
    }
}