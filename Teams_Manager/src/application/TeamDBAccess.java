package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static void addTeam(Team team) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("insert into teams values(?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, team.getName());
		stmt.setString(2, team.getCoach());
		stmt.setString(3, team.getState());
		stmt.setString(4, team.getCity());
		
		stmt.executeUpdate();
	}
	
	public static boolean validateAdd(Team team) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("select * from teams where name=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, team.getName());
		
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			return true;
		}
		stmt.close();
		return false;
	}
	
	public static Team getTeam(String userTeamName) throws SQLException{
		Team team;
		conn = DBConnection.getMyConnection();

		String query = ("select * from teams where name=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, userTeamName);
		
		ResultSet rs = stmt.executeQuery();
		if(!rs.next()) {
			team=null;
		}
		else {
			team=buildTeam(rs);
		}
		return team;
	}
	
	public static ArrayList<String> getTeams(String username) throws SQLException{
		ArrayList<String> teams;
		conn = DBConnection.getMyConnection();

		String query = ("select name from teams where coach_username=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, username);
		
		ResultSet rs = stmt.executeQuery();
		if(!rs.next()) {
			teams=null;
		}
		else {
			teams=buildTeamsList(rs);
		}
		return teams;
	}
	
	private static ArrayList<String> buildTeamsList(ResultSet rs) throws SQLException{
		rs.beforeFirst();
		ArrayList<String> teams= new ArrayList<String>();
		while(rs.next()) {
			teams.add(rs.getString(1));
		}
		
		return teams;
	}
	
	private static Team buildTeam(ResultSet rs) throws SQLException {
		String name = rs.getString("name");
		String coach = rs.getString("coach_username");
		String state = rs.getString("state");
		String city = rs.getString("city");

		Team team = new Team(name, coach, state, city);
		return team;
	}
}
