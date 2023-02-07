package fr.upjv.cisco.data;

import fr.upjv.cisco.bdd.LivreBdd;

import java.util.Scanner;

public class Livre {
    String titre;
    String auteur;
    String genre;
    String description;

    public Livre(String titre, String auteur, String genre, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.description = description;
    }

    public Livre(){
        //scan du clavier
        Scanner scanner = new Scanner(System.in);
        System.out.println("Titre du livre: ");
        titre = scanner.nextLine();

        System.out.println("Auteur du livre: ");
        auteur = scanner.nextLine();

        System.out.println("Genre du livre: ");
        genre = scanner.nextLine();

        System.out.println("Description du livre: ");
        description = scanner.nextLine();

        LivreBdd livreBdd = new LivreBdd(titre, auteur, genre, description);
    }
}
