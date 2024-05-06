package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.JDBCUtils;

public class AuthentificationDAO {

    public static boolean authenticate(String username, String password, String role) throws SQLException {
        PreparedStatement pstmt;
        ResultSet rs = null;
        try {
        	pstmt = JDBCUtils.getConnection().prepareStatement(
        		    "SELECT * FROM login WHERE username = ? AND password = ? AND role = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            rs = pstmt.executeQuery();
            return rs.next(); // Si une correspondance est trouvée, l'authentification est réussie
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}
