package adapter;

public class ImplNonStandard {
    public int[] appliquerFiltre(String filterName, int[] data) {
        System.out.println("Application de l'ancien filtre : " + filterName);
        return data;
    }
}