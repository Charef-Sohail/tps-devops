import obs.ObservableImplementation;
import obs.Observer;
import obs.ObserverImplementation1;
import obs.ObserverImplementation2;

void main() {
    ObservableImplementation observable = new ObservableImplementation();


    Observer o1 = new ObserverImplementation1();
    Observer o2 = new ObserverImplementation2();

    observable.subscribe(o1);
    observable.subscribe(o2);


    IO.println("--- Setting state to 60 ---");
    observable.setState(60);

    IO.println("--- Setting state to 80 ---");
    observable.setState(80);


    observable.unsubscribe(o1);

    IO.println("--- Setting state to 100 (Observer 1 is unsubscribed) ---");
    observable.setState(100);


    observable.subscribe(obs -> {
        if (obs instanceof ObservableImplementation obsImpl) {
            IO.println("Anonymous Observer calculated: " + Math.cos(obsImpl.getState()));
        }
    });

    IO.println("--- Setting state to 120 ---");
    observable.setState(120);
}
