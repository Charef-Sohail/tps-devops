package image;

import strategy.IFiltreStrategy;
import templatemethod.CompresseurTemplate;

public class FrameworkImage {
    private IFiltreStrategy filtre;
    private CompresseurTemplate compresseur;

    public void setFiltre(IFiltreStrategy filtre) {
        this.filtre = filtre;
    }

    public void setCompresseur(CompresseurTemplate compresseur) {
        this.compresseur = compresseur;
    }

    public int[] traiterImage(int[] data) {
        System.out.println("\n=== DÉBUT DU TRAITEMENT DE L'IMAGE ===");

        int[] dataFiltree = data;
        if (filtre != null) {
            dataFiltree = filtre.filter(data);
        }

        int[] dataCompressee = dataFiltree;
        if (compresseur != null) {
            dataCompressee = compresseur.compresserImage(dataFiltree);
        }

        System.out.println("=== FIN DU TRAITEMENT ===\n");
        return dataCompressee;
    }
}
