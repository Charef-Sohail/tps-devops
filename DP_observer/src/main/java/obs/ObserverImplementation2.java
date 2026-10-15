package obs;

import java.util.ArrayList;
import java.util.List;

public class ObserverImplementation2 implements Observer {
    private final List<Integer> history = new ArrayList<>();

    @Override
    public void update(Observable observable) {
        if (observable instanceof ObservableImplementation obsImpl) {
            int newState = obsImpl.getState();
            history.add(newState);

            double sum = 0;
            for (int i = 0; i < history.size(); i++) {
                sum += history.get(i);
            }
            double average = sum / history.size();
            System.out.println("Observer 2 (Average so far): " + average);
        }
    }
}