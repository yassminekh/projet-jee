package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AgentTirage;
import utils.JDBCUtils;


public class AgentTirageDAO {

    public static  AgentTirage getByUsernameAndPassword(String username, String password) {
        PreparedStatement pstmt;
        AgentTirage agentTirage = null;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "SELECT * FROM agent_tirage WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                agentTirage = new AgentTirage(2, rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agentTirage;
    }

    public List<AgentTirage> findAll() {
        PreparedStatement pstmt;
        List<AgentTirage> agentsTirage = new ArrayList<>();
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement("SELECT * FROM agent_tirage");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AgentTirage agentTirage = new AgentTirage(2, rs.getString("username"), rs.getString("password"));
                agentsTirage.add(agentTirage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agentsTirage;
    }

    public void save(AgentTirage agentTirage) {
        PreparedStatement pstmt;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(
                "INSERT INTO agent_tirage (username, password) VALUES (?, ?)");
            pstmt.setString(1, agentTirage.getUsername());
            pstmt.setString(2, agentTirage.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   }
