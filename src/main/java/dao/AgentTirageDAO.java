package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AgentTirage;
import utils.JDBCUtils;

public class AgentTirageDAO {

    public static boolean authenticate(String username, String password) {
        try {
            // Utiliser le DAO AuthentificationDAO pour authentifier l'utilisateur
            return AuthentificationDAO.authenticate(username, password, "agent_tirage");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void save(AgentTirage agentTirage) {
        PreparedStatement pstmt;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO agent_tirage (nom, email, password) VALUES (?, ?, ?)");
            pstmt.setString(1, agentTirage.getNom());
            pstmt.setString(2, agentTirage.getEmail());
            pstmt.setString(3, agentTirage.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
