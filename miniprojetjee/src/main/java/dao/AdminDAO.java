package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Administrateur;
import utils.JDBCUtils;


public class AdminDAO {

    public static Administrateur getByUsernameAndPassword(String username, String password) {
        PreparedStatement pstmt;
        Administrateur admin = null;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "SELECT * FROM admins WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                admin = new Administrateur(1, rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public List<Administrateur> findAll() {
        PreparedStatement pstmt;
        List<Administrateur> admins = new ArrayList<>();
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement("SELECT * FROM admins");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Administrateur admin = new Administrateur(1, rs.getString("username"), rs.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public void save(Administrateur admin) {
        PreparedStatement pstmt;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO admins (username, password) VALUES (?, ?)");
            pstmt.setString(1, admin.getNom());
            pstmt.setString(2, admin.getMotDePasse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
