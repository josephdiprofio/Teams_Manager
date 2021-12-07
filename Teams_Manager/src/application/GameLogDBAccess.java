package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameLogDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static ArrayList<BoxScore> getScores(String teamName) throws SQLException{
		ArrayList<BoxScore> data;
		conn = DBConnection.getMyConnection();
		
		String query = ("select user_team, nonuser_team, home_score, away_score, year from game_log where user_team=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, teamName);
		
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			data=null;
		}
		else {
			data=buildGameResults(rs);
		}
		
		return data;
	}
	
	private static ArrayList<BoxScore> buildGameResults(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		ArrayList<BoxScore> scores=new ArrayList<BoxScore>();
		while(rs.next()) {
			String userTeam=rs.getString(1);
			String oppTeam=rs.getString(2);
			int userScore= rs.getInt(3);
			int oppScore= rs.getInt(4);
			int year= rs.getInt(5);
			
			BoxScore game= new BoxScore(userTeam, oppTeam, userScore, oppScore, year);
			scores.add(game);
		}
		return scores;
	}
}
