package fr.upjv.cisco.bdd;

import java.sql.*;

public class AffichageTable {
    public AffichageTable() {
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
            stmt = connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        String affichageBdd = "SELECT * FROM lecteurs";

        ResultSet monResultSet = null;
        System.out.println("\n -------------------------------- \n");
        try {
            monResultSet=stmt.executeQuery(affichageBdd);
            while (monResultSet.next()){
                String prenom = monResultSet.getString("prenom");
                String nom = monResultSet.getString("nom");

                System.out.println("prenom: " + prenom + " | nom: " + nom);
            }
            System.out.println("\n -------------------------------- \n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur lors de l'envoi de la requete SQL");
            System.exit(-1);
        }

        affichageBdd = "SELECT * FROM livres";

        monResultSet = null;

        try {
            monResultSet=stmt.executeQuery(affichageBdd);
            while (monResultSet.next()){
                String titre = monResultSet.getString("titre");
                String auteur = monResultSet.getString("auteur");
                String genre = monResultSet.getString("genre");
                String description = monResultSet.getString("description");

                System.out.println("titre: " + titre + " | auteur: " + auteur +
                        " | genre: " + genre + " | description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur lors de l'envoi de la requete SQL");
            System.exit(-1);
        }

        try {
            connexion.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
