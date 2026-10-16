package strategy;

public class FiltreStandardB implements IFiltreStrategy {
    @Override
    public int[] filter(int[] data) {
        System.out.println("Application du filtre B");
        return data;
    }
}