package fr.upjv.cisco.data;

import fr.upjv.cisco.bdd.LivreBdd;

import java.util.Scanner;

public class Livre {
    String titre;
    String auteur;
    String genre;
    String description;

    //definission du constructeur Livre
    public Livre(String titre, String auteur, String genre, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.description = description;
    }

    //constructeur Livre sans paramètre
    public Livre(){
        //scan du clavier pour chaque string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Titre du livre: ");
        titre = scanner.nextLine();

        System.out.println("Auteur du livre: ");
        auteur = scanner.nextLine();

        System.out.println("Genre du livre: ");
        genre = scanner.nextLine();

        System.out.println("Description du livre: ");
        description = scanner.nextLine();

        //création de l'objet livreBdd
        LivreBdd livreBdd = new LivreBdd(titre, auteur, genre, description);
    }
}
