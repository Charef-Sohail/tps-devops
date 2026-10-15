package obs;

public class ObserverImplementation1 implements Observer {
    @Override
    public void update(Observable observable) {
        if (observable instanceof ObservableImplementation obsImpl) {
            int state = obsImpl.getState();
            System.out.println("Observer 1 received new state: " + state);
        }
    }
}