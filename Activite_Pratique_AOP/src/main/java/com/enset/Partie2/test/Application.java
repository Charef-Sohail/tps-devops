package com.enset.Partie2.test;

import com.enset.Partie2.metier.Compte;
import com.enset.Partie2.metier.IMetierBanque;
import com.enset.Partie2.metier.MetierImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new Application().start();
    }

    public void start() {
        System.out.println("Démarrage de l'application...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez le code du compte : ");
        Long code = scanner.nextLong();
        System.out.print("Donnez le solde initial du compte : ");
        double solde = scanner.nextDouble();

        IMetierBanque metier = new MetierImpl();
        metier.addCompte(new Compte(code, solde));

        while (true) {
            try {
                System.out.print("Type d'opération (versement, retrait, quitter) : ");
                String type = scanner.next();

                if (type.equals("quitter")) {
                    System.out.println("Fin de l'application.");
                    break;
                }

                System.out.print("Montant de l'opération : ");
                double montant = scanner.nextDouble();

                if (type.equals("versement")) {
                    metier.verser(code, montant);
                } else if (type.equals("retrait")) {
                    metier.retirer(code, montant);
                }

                System.out.println("État du compte : " + metier.consulter(code).toString());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}