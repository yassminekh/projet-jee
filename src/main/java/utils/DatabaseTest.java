package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseTest {

    // M�thode pour tester la connexion � la base de donn�es
    	  public static void main(String[] args) {
    	        try {
    	            Connection conn = JDBCUtils.getConnection();
    	            if (conn != null) {
    	                System.out.println("Connexion � la base de donn�es �tablie avec succ�s !");
    	                conn.close(); // Fermer la connexion apr�s utilisation
    	            } else {
    	                System.out.println("La connexion � la base de donn�es a �chou�.");
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
}
