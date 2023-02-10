package fr.upjv.cisco.bdd;

import java.sql.*;

public class LecteurBdd {
    String prenom;
    String nom;

    public LecteurBdd(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;

        String driverMysql = "com.mysql.cj.jdbc.Driver";
        //url BDD
        String urlBDD = "jdbc:mysql://localhost:3306/mabd";

        try {
            Class.forName(driverMysql);
            System.out.println("Chargement du driver mysql ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Echec du chargement du driver mysql");
            System.exit(-1);
        }

        Connection connexion=null;

        //création d'une table
        String creationtable = "CREATE TABLE IF NOT EXISTS lecteurs("+
                "prenom VARCHAR(255),"+
                "nom VARCHAR(255)" +
                ")";

        //connexion a la base

        Statement stmt = null;

        try {
            connexion = DriverManager.getConnection(urlBDD, "root", "root");
            System.out.println("Connection a la base OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection echoué");
            System.exit(-1);
        }

        try {
            stmt=connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //execution de la requete
        try {
            stmt.executeUpdate(creationtable);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //requete SQL
        String requeteInsertion = "INSERT INTO lecteurs (prenom, nom) " +
                "VALUES ('" + prenom + "', '" + nom + "')";

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
