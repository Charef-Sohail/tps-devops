package templatemethod;

public class CompresseurRar extends CompresseurTemplate {

    @Override
    protected int[] etape1PreTraitement(int[] data) {
        System.out.println("Préparation des données pour le format RAR...");
        return data;
    }

    @Override
    protected int[] etape2AlgorithmeCompression(int[] data) {
        System.out.println("Application de l'algorithme de compression RAR...");
        return data;
    }
}
