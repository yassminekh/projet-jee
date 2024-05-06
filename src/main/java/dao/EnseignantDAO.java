package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Enseignant;
import utils.JDBCUtils;

public class EnseignantDAO {

    public static boolean authenticate(String username, String password) {
        try {
            // Utiliser le DAO AuthentificationDAO pour authentifier l'utilisateur
            return AuthentificationDAO.authenticate(username, password, "enseignant");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void save(Enseignant enseignant) {
        PreparedStatement pstmt;
        try {
        	pstmt = JDBCUtils.getConnection().prepareStatement(
        		    "INSERT INTO enseignant (nom, email, password) VALUES (?, ?, ?)");
        		pstmt.setString(1, enseignant.getNom());
        		pstmt.setString(2, enseignant.getEmail());
        		pstmt.setString(3, enseignant.getPassword()); // Ajout du mot de passe
        		pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
