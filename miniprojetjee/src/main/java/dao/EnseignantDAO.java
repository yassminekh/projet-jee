package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Enseignant;
import utils.JDBCUtils;


public class EnseignantDAO {

    public static Enseignant getByUsernameAndPassword(String username, String password) {
        PreparedStatement pstmt;
        Enseignant enseignant = null;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "SELECT * FROM enseignant WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                enseignant = new Enseignant(0, rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }

    public List<Enseignant> findAll() {
        PreparedStatement pstmt;
        List<Enseignant> enseignants = new ArrayList<>();
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement("SELECT * FROM enseignant");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Enseignant enseignant = new Enseignant(0, rs.getString("username"), rs.getString("password"));
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }

    public void save(Enseignant enseignant) {
        PreparedStatement pstmt;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO enseignant (username, password) VALUES (?, ?)");
            pstmt.setString(1, enseignant.getNom());
            pstmt.setString(2, enseignant.getMotDePasse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
