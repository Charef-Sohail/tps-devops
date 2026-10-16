package templatemethod;

public abstract class CompresseurTemplate {
  public final int[] compresserImage(int[] data) {
        System.out.println("--- Début de la compression ---");
        int[] dataFiltree = etape1PreTraitement(data);
        int[] dataCompressee = etape2AlgorithmeCompression(dataFiltree);
        System.out.println("--- Fin de la compression ---");

        return dataCompressee;
    }

    protected abstract int[] etape1PreTraitement(int[] data);
    protected abstract int[] etape2AlgorithmeCompression(int[] data);
}
