package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Administrateur;
import utils.JDBCUtils;

public class AdminDAO {

    public static boolean authenticate(String username, String password) {
        try {
            // Utiliser le DAO AuthentificationDAO pour authentifier l'utilisateur
            return AuthentificationDAO.authenticate(username, password, "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void save(Administrateur administrateur) {
        PreparedStatement pstmt;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO administrateur (nom, email, password) VALUES (?, ?, ?)");
            pstmt.setString(1, administrateur.getNom());
            pstmt.setString(2, administrateur.getEmail());
            pstmt.setString(3, administrateur.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
