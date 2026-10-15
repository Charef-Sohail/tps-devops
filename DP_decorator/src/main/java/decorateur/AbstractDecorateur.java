package decorateur;

import composant.Boisson;

public abstract class AbstractDecorateur extends Boisson {
    protected Boisson boisson;

    public AbstractDecorateur(Boisson boisson) {
        this.boisson = boisson;
    }

    public abstract String getDescription();
}