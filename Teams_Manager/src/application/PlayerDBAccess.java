package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static void addPlayer(Player player) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("insert into players values(?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, player.getName());
		stmt.setString(2, player.getTeam());
		stmt.setString(3, player.getHeight());
		stmt.setString(4, player.getWeight());
		
		stmt.executeUpdate();
	}
	
	public static boolean validateAdd(Player player) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query = ("select * from players where name=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, player.getName());
		
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			return true;
		}
		stmt.close();
		return false;
	}
	
	public static ArrayList<Player> getPlayers(String userTeamName) throws SQLException {
		ArrayList<Player> players;
		conn = DBConnection.getMyConnection();

		String query = ("select * from players where team=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, userTeamName);
		
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			players=buildPlayerList(rs);
		}
		else {
			players=null;
		}
		stmt.close();
		return players;
	}
	
	public static ArrayList<Player> getPlayerTotals(String playerName) throws SQLException {
		ArrayList<Player> players;
		conn = DBConnection.getMyConnection();

		String query = ("select name, year, sum(players_data.made_shots), sum(players_data.missed_shots), sum(players_data.rebounds), sum(players_data.points), sum(players_data.assists), sum(players_data.steals), sum(players_data.blocks), sum(players_data.turnovers), sum(wins), sum(losses) from players_data, players, teams_data where player_name=players.name and players.team=team_name and players_data.id=teams_data.id and player_name=? group by year");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, playerName);
		
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			players=buildPlayerTotals(rs);
		}
		else {
			players=null;
		}
		stmt.close();
		return players;
	}
	
	public static Player getAllTimePlayerTotals(String playerName) throws SQLException {
		Player playerTotals;
		conn = DBConnection.getMyConnection();

		String query = ("select sum(players_data.made_shots), sum(players_data.missed_shots), sum(players_data.rebounds), sum(players_data.points), sum(players_data.assists), sum(players_data.steals), sum(players_data.blocks), sum(players_data.turnovers), sum(wins), sum(losses) from players_data, players, teams_data where player_name=players.name and players.team=team_name and players_data.id=teams_data.id and player_name=?");
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, playerName);
		
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			playerTotals=buildAllTimePlayerTotals(rs);
		}
		else {
			playerTotals=null;
		}
		stmt.close();
		return playerTotals;
	}
	
	private static ArrayList<Player> buildPlayerList(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		ArrayList<Player> players=new ArrayList<Player>();
		while(rs.next()) {
			String name = rs.getString("name");
			String team = rs.getString("team");
			String height = rs.getString("height");
			String weight = rs.getString("weight");
			
			Player player= new Player(name, team, height, weight);
			players.add(player);
		}
		
		return players;
	}
	
	private static ArrayList<Player> buildPlayerTotals(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		ArrayList<Player> playerTotals=new ArrayList<Player>();
		
		while(rs.next()) {
			String name=rs.getString(1);
			int year= rs.getInt(2);
			int madeShots=rs.getInt(3);
			int missedShots=rs.getInt(4);
			int rebounds=rs.getInt(5);
			int points=rs.getInt(6);
			int assists=rs.getInt(7);
			int steals=rs.getInt(8);
			int blocks= rs.getInt(9);
			int turnovers=rs.getInt(10);
			int wins=rs.getInt(11);
			int losses=rs.getInt(12);
			
			Player playerTotal=new Player(name, year, madeShots, missedShots, rebounds, points, assists, steals, blocks, turnovers, wins, losses);
			playerTotals.add(playerTotal);
		}
		
		return playerTotals;
	}
	
	private static Player buildAllTimePlayerTotals(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		rs.next();
		
		int madeShots=rs.getInt(1);
		int missedShots=rs.getInt(2);
		int rebounds=rs.getInt(3);
		int points=rs.getInt(4);
		int assists=rs.getInt(5);
		int steals=rs.getInt(6);
		int blocks= rs.getInt(7);
		int turnovers=rs.getInt(8);
		int wins=rs.getInt(9);
		int losses=rs.getInt(10);
		
		Player playerTotal=new Player(madeShots, missedShots, rebounds, points, assists, steals, blocks, turnovers, wins, losses);
		return playerTotal;
	}
}
