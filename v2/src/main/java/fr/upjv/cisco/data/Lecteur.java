package fr.upjv.cisco.data;

import fr.upjv.cisco.bdd.LecteurBdd;

import java.util.Scanner;

public class Lecteur {
    String prenom;
    String nom;

    public Lecteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    public Lecteur(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prenom du lecteur: ");
        prenom = scanner.nextLine();

        System.out.println("Nom du lecteur: ");
        nom = scanner.nextLine();

        LecteurBdd insertionlecteur = new LecteurBdd(prenom, nom);
    }
}
