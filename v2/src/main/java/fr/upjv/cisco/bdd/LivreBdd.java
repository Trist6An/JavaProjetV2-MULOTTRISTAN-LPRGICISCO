package fr.upjv.cisco.bdd;

import java.sql.*;

public class LivreBdd {
    String titre;
    String auteur;
    String genre;
    String description;

    //constructeur LivreBdd
    public LivreBdd(String titre, String auteur, String genre, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.description = description;

        //driver MySQL
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        //url BDD
        String urlBDD = "jdbc:mysql://localhost:3306/mabd";
        //chargement driver mysql
        try {
            Class.forName(driverMysql);
            System.out.println("Chargement du driver mysql ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Echec du chargement du driver mysql");
            System.exit(-1);
        }

        //definition de connexion a null
        Connection connexion=null;

        //Requete 1 : création d'une table SQL
        String creationtable = "CREATE TABLE IF NOT EXISTS livres("+
                "titre VARCHAR(255),"+
                "auteur VARCHAR(255),"+
                "genre VARCHAR(255),"+
                "description VARCHAR(255)"+
                ")";

        //connexion a la base
        try {
            connexion = DriverManager.getConnection(urlBDD, "root", "root");
            System.out.println("Connection a la base OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection echoué");
            System.exit(-1);
        }

        Statement stmt = null;
        //try catch pour gérer l'exception du statement
        try {
            stmt=connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //execution de la requete 1
        try {
            stmt.executeUpdate(creationtable);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //Requete 2: insertion des valeurs dans la table livres
        String requeteInsertion = "INSERT INTO livres (titre, auteur, genre, description) " +
                "VALUES ('" + titre + "', '" + auteur + "', '" + genre + "', '" + description + "')";

        try {
            stmt.executeUpdate(requeteInsertion);
            System.out.println("Données bien envoyé dans la base !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur lors de l'envoi des données a la base !");
            System.exit(-1);
        }

        //fermeture des connections
        try {
            connexion.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
