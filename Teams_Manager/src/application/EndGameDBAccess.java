package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EndGameDBAccess {
	private static Connection conn;

	
	 //initializes the database connection class with the name of the database
	 
	public static void init() throws ClassNotFoundException {
		DBConnection.init("teams_manager");
	}
	
	public static void endGame(Game game) throws SQLException {
		conn = DBConnection.getMyConnection();

		String query1 = ("insert into game_log (user_team, nonuser_team, home_score, away_score, year) values(?,?,?,?,?)");
		PreparedStatement stmt1 = conn.prepareStatement(query1);
		
		stmt1.setString(1, game.getUserTeam().getName());
		stmt1.setString(2, game.getOppTeam());
		stmt1.setInt(3, game.getUserScore());
		stmt1.setInt(4, game.getOppScore());
		stmt1.setInt(5, game.getYear());
		
		stmt1.executeUpdate();
		
		
		String query2 = ("insert into opponent_totals (user_team, year, points, rebounds, made_shots, missed_shots, assists, steals, blocks) values(?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		
		
		stmt2.setString(1, game.getUserTeam().getName());
		stmt2.setInt(2, game.getYear());
		stmt2.setInt(3, game.getOppScore());
		stmt2.setInt(4, game.getOppRebounds());
		stmt2.setInt(5, game.getOppMadeShots());
		stmt2.setInt(6, game.getOppMissedShots());
		stmt2.setInt(7, game.getOppAssists());
		stmt2.setInt(8, game.getOppSteals());
		stmt2.setInt(9, game.getOppBlocks());
		
		stmt2.executeUpdate();
		
		
		ArrayList<Player> players= game.getUserTeam().getPlayers();
		String query3 = ("insert into players_data (player_name, made_shots, missed_shots, rebounds, points, assists, steals, blocks, turnovers) values(?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		
		for(Player player: players) {
			
			stmt3.setString(1, player.getName());
			stmt3.setInt(2, player.getMadeShots());
			stmt3.setInt(3, player.getMissedShots());
			stmt3.setInt(4, player.getRebounds());
			stmt3.setInt(5, player.getPoints());
			stmt3.setInt(6, player.getAssists());
			stmt3.setInt(7, player.getSteals());
			stmt3.setInt(8, player.getBlocks());
			stmt3.setInt(9, player.getTurnovers());
			
			stmt3.executeUpdate();
		}
		
		
		String query4 = ("insert into teams_data (team_name, year, wins, losses, rebounds, points, made_shots, missed_shots, assists, steals, blocks, turnovers) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		
		
		stmt4.setString(1, game.getUserTeam().getName());
		stmt4.setInt(2, game.getYear());
		stmt4.setInt(3, game.getUserWin());
		stmt4.setInt(4, game.getUserLoss());
		stmt4.setInt(5, game.getUserRebounds());
		stmt4.setInt(6, game.getUserScore());
		stmt4.setInt(7, game.getUserMadeShots());
		stmt4.setInt(8, game.getUserMissedShots());
		stmt4.setInt(9, game.getUserAssists());
		stmt4.setInt(10, game.getUserSteals());
		stmt4.setInt(11, game.getUserBlocks());
		stmt4.setInt(12, game.getUserTurnovers());
		stmt4.executeUpdate();
		
	}
}
