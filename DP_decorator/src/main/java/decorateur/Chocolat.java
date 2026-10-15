package decorateur;

import composant.Boisson;

public class Chocolat extends AbstractDecorateur {

    public Chocolat(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au Chocolat";
    }

    @Override
    public double cout() {
        return 1.2 + boisson.cout();
    }
}