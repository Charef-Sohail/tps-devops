package strategy;

public class FiltreStandardA implements IFiltreStrategy {
    @Override
    public int[] filter(int[] data) {
        System.out.println("Application du filtre A");
        return data;
    }
}