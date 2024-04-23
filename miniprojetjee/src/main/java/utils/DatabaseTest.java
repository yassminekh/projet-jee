package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseTest {

    // Méthode pour tester la connexion à la base de données
    	  public static void main(String[] args) {
    	        try {
    	            Connection conn = JDBCUtils.getConnection();
    	            if (conn != null) {
    	                System.out.println("Connexion à la base de données établie avec succès !");
    	                conn.close(); // Fermer la connexion après utilisation
    	            } else {
    	                System.out.println("La connexion à la base de données a échoué.");
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
}
