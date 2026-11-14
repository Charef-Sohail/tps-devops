package com.enset.Partie2.metier;

public interface IMetierBanque {
    void addCompte(Compte cp);
    void verser(Long code, double montant);
    void retirer(Long code, double montant);
    Compte consulter(Long code);
}