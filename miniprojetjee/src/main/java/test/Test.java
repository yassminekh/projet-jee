package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Test {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection ctx = DriverManager.getConnection("jdbc:mysql://"
					+ "localhost:3306/tirage", "root", "");
			PreparedStatement pstmt = ctx.prepareStatement(""
					+ "insert into enseignant values (0,?,?,?,?)");
			pstmt.setString(1, "yassmine");
			pstmt.setString(2, "Ahmed");
			pstmt.setString(3, "admin");
			pstmt.setString(4, "123");
			pstmt.executeUpdate();
			pstmt.close();
			ctx.close();
			PreparedStatement pstmt2 = ctx.prepareStatement(""
					+ "insert into administrateur values (0,?,?,?,?)");
			pstmt2.setString(1, "yassmine");
			pstmt2.setString(2, "Ahmed");
			pstmt2.setString(3, "admin");
			pstmt2.setString(4, "123");
			pstmt2.executeUpdate();
			pstmt2.close();
			ctx.close();
			PreparedStatement pstmt3 = ctx.prepareStatement(""
					+ "insert into agentTirage values (0,?,?,?,?)");
			pstmt3.setString(1, "yassmine");
			pstmt3.setString(2, "Ahmed");
			pstmt3.setString(3, "admin");
			pstmt3.setString(4, "123");
			pstmt3.executeUpdate();
			pstmt3.close();
			ctx.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
