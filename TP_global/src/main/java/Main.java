import image.FrameworkImage;
import strategy.IFiltreStrategy;
import templatemethod.CompresseurTemplate;

void main() {
    FrameworkImage framework = new FrameworkImage();
    Scanner scanner = new Scanner(System.in);
    int[] monImage = {255, 128, 64, 32};

    try {
        System.out.print("Entrez le nom complet de la classe du Filtre (ex: strategy.FiltreStandardA) : ");
        String nomClasseFiltre = scanner.nextLine();

        IFiltreStrategy filtre = (IFiltreStrategy) Class.forName(nomClasseFiltre)
                .getDeclaredConstructor()
                .newInstance();
        framework.setFiltre(filtre);

        System.out.print("Entrez le nom complet de la classe du Compresseur (ex: templatemethod.CompresseurZip) : ");
        String nomClasseCompresseur = scanner.nextLine();


        CompresseurTemplate compresseur = (CompresseurTemplate) Class.forName(nomClasseCompresseur)
                .getDeclaredConstructor()
                .newInstance();
        framework.setCompresseur(compresseur);


        framework.traiterImage(monImage);

    } catch (Exception e) {
        System.out.println("Erreur : Classe introuvable ou instanciation impossible.");
        e.printStackTrace();
    }

    scanner.close();
}