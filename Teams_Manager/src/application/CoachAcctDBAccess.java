package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoachAcctDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static Boolean authenticate(String username, String password) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("select * from coach_accounts where username=? and password=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			return false;
		}
		stmt.close();
		return true;
	}
	
	public static void addAccount(String username, String password) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("insert into coach_accounts values(?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		stmt.executeUpdate();
	}
	
	public static int update(String oldUsername, String newUsername, String newPassword) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("update coach_accounts set username=?, password=? where username=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, newUsername);
		stmt.setString(2, newPassword);
		stmt.setString(3, oldUsername);
		
		int result=stmt.executeUpdate();
		return result;
	}
}
