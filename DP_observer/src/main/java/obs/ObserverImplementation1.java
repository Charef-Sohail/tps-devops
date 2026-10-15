package obs;

public class ObserverImplementation1 implements Observer {
    @Override
    public void update(int newState) {
            System.out.println("Observer 1 received new state: " + newState);
    }
}