package fr.upjv.cisco;

import fr.upjv.cisco.bdd.AffichageTable;
import fr.upjv.cisco.data.Lecteur;
import fr.upjv.cisco.data.Livre;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // initalisation du scanner

        //création des listes livres et lecteurs
        ArrayList<Livre> livres = new ArrayList<>();
        ArrayList<Lecteur> lecteurs = new ArrayList<>();


        int choix = 0;

        //boucle while pour faire un menu
        while (choix == 0) {
            System.out.println("Choisir une option");
            System.out.println("1 - Créer un livre");
            System.out.println("2 - Créer un lecteur");
            System.out.println("3 - Afficher les livres et les lecteurs présent dans la base de donnée");
            System.out.println("4 - Quitter le programme");
            System.out.println("en attente de choix...");
            choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1){
                Livre livre = new Livre(); //création d'un livre
            }else if (choix == 2){
                Lecteur lecteur = new Lecteur(); //création d'un lecteur
            }else if (choix == 3){
                //affichage lecteur et livre
                AffichageTable affichage = new AffichageTable();
            }else if (choix == 4){
                System.out.println("Programme quitté...");
                System.exit(0);
            }else if (choix > 4){
                System.out.println("merci de renseigner un choix disponible");
            }
            choix = 0;
            System.out.println("------------------------------------------------ \n");
        }
    }
}