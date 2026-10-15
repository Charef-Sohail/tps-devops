package obs;

import java.util.ArrayList;
import java.util.List;

public class ObservableImplementation implements Observable {
    private int state = 0;
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setState(int state) {
        this.state = state;
        this.notifyObservers();
    }

    public int getState() {
        return state;
    }
}