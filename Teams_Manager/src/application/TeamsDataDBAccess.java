package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamsDataDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static ArrayList<TeamTotals> getYearlyTotals(Team team) throws SQLException{
		ArrayList<TeamTotals> data;
		conn = DBConnection.getMyConnection();
		
		String query = ("select teams_data.year, sum(wins), sum(losses), sum(teams_data.rebounds), sum(teams_data.points), sum(teams_data.made_shots), sum(teams_data.missed_shots), sum(teams_data.assists), sum(teams_data.steals), sum(teams_data.blocks), sum(teams_data.turnovers), sum(opponent_totals.points) from teams_data, opponent_totals where team_name=user_team and teams_data.id=opponent_totals.id and user_team=? group by teams_data.year;");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, team.getName());
		
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			data=null;
		}
		else {
			data=buildYearlyDataList(rs);
		}
		
		return data;
		
	}
	
	public static TeamTotals getAllTimeTotals(Team team) throws SQLException{
		TeamTotals data;
		conn = DBConnection.getMyConnection();
		
		String query = ("select sum(wins), sum(losses), sum(teams_data.rebounds), sum(teams_data.points), sum(teams_data.made_shots), sum(teams_data.missed_shots), sum(teams_data.assists), sum(teams_data.steals), sum(teams_data.blocks), sum(teams_data.turnovers), sum(opponent_totals.points) from teams_data, opponent_totals where team_name=user_team and teams_data.id=opponent_totals.id and user_team=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, team.getName());
		
		ResultSet rs = stmt.executeQuery();
		if (!rs.next()) {
			data=null;
		}
		else {
			data=buildAllTimeData(rs);
		}
		return data;
	}
	
	
	private static ArrayList<TeamTotals> buildYearlyDataList(ResultSet rs) throws SQLException {
		ArrayList<TeamTotals> data= new ArrayList<TeamTotals>();
		rs.beforeFirst();
		
		while(rs.next()) {
			int year= rs.getInt(1);
			int wins= rs.getInt(2);
			int losses= rs.getInt(3);
			int rebounds= rs.getInt(4);
			int points= rs.getInt(5);
			int made_shots= rs.getInt(6);
			int missed_shots= rs.getInt(7);
			int assists= rs.getInt(8);
			int steals= rs.getInt(9);
			int blocks= rs.getInt(10);
			int turnovers= rs.getInt(11);
			int oppPoints= rs.getInt(12);
			
			TeamTotals totals= new TeamTotals(year, wins, losses, rebounds, points, made_shots, missed_shots, assists, steals, blocks, turnovers, oppPoints);
			data.add(totals);
		}
		
		return data;
	}
	
	private static TeamTotals buildAllTimeData(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		rs.next();
		
		int wins= rs.getInt(1);
		int losses= rs.getInt(2);
		int rebounds= rs.getInt(3);
		int points= rs.getInt(4);
		int made_shots= rs.getInt(5);
		int missed_shots= rs.getInt(6);
		int assists= rs.getInt(7);
		int steals= rs.getInt(8);
		int blocks= rs.getInt(9);
		int turnovers= rs.getInt(10);
		int oppPoints= rs.getInt(11);
			
		TeamTotals totals= new TeamTotals(wins, losses, rebounds, points, made_shots, missed_shots, assists, steals, blocks, turnovers, oppPoints);
			
		
		return totals;
	}
	
}
