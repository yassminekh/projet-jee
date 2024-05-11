package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Enseignant;
import utils.JDBCUtils;

public class EnseignantDAO {

    public static boolean authenticate(String username, String password) {
        try {
            // Utiliser le DAO AuthentificationDAO pour authentifier l'utilisateur
            return AuthentificationDAO.authenticate(username, password,"enseignant");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void save(Enseignant enseignant) {
        PreparedStatement pstmt;
        try {
        	pstmt = JDBCUtils.getConnection().prepareStatement(
        		    "INSERT INTO enseignant (username,email, password) VALUES (?, ?, ?)");
        		pstmt.setString(1, enseignant.getUsername());
        		pstmt.setString(2, enseignant.getEmail());
        		pstmt.setString(3, enseignant.getPassword()); 
        		pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void create(Enseignant enseignant) {
        try {
            PreparedStatement pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO enseignant (username, email, password) VALUES (?, ?, ?)");
            pstmt.setString(1, enseignant.getUsername());
            pstmt.setString(2, enseignant.getEmail());
            pstmt.setString(3, enseignant.getPassword()); 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(Enseignant enseignant) {
        try {
            PreparedStatement pstmt = JDBCUtils.getConnection().prepareStatement(
                "UPDATE enseignant SET email = ?, password = ? WHERE username = ?");
            pstmt.setString(1, enseignant.getEmail());
            pstmt.setString(2, enseignant.getPassword());
            pstmt.setString(3, enseignant.getUsername());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(int id) {
        try {
            PreparedStatement pstmt = JDBCUtils.getConnection().prepareStatement(
                "DELETE FROM enseignant WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String query = "SELECT * FROM enseignant";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                Enseignant enseignant = new Enseignant(username, email, password);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return enseignants;
    }
    public static Enseignant getEnseignantById(int id) {
        Enseignant enseignant = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String query = "SELECT * FROM enseignant WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                enseignant = new Enseignant(username, email, password);
                enseignant.setIdEnseigant(id); // Assurez-vous que la classe Enseignant a une méthode setId()
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return enseignant;
    }


}
