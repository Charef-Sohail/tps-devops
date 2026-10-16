package adapter;

import strategy.IFiltreStrategy;

public class FiltreAdapter implements IFiltreStrategy {
    private ImplNonStandard ancienneImpl;
    private String nomDuFiltre;

    public FiltreAdapter(String nomDuFiltre, ImplNonStandard ancienneImpl) {
        this.nomDuFiltre = nomDuFiltre;
        this.ancienneImpl = ancienneImpl;
    }

    @Override
    public int[] filter(int[] data) {
        return ancienneImpl.appliquerFiltre(nomDuFiltre, data);
    }
}