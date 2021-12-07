package application;


import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerStatsDisplay {
	static GridPane gridPane = new GridPane();
	static Scene playerStatsDisplayScene;
	static Button btHome= new Button("Home");
	public static void display(Stage primaryStage, ArrayList<Player> playerTotals, Player allTimePlayerTotals, String name) {
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Player Statistics for "+name+": "), 0, 0);
		gridPane.add(new Label("Year"), 0, 1);
		gridPane.add(new Label("Games"), 1, 1);
		gridPane.add(new Label("FGA"), 2, 1);
		gridPane.add(new Label("FG%"), 3, 1);
		gridPane.add(new Label("PPG"), 4, 1);
		gridPane.add(new Label("APG"), 5, 1);
		gridPane.add(new Label("RPG"), 6, 1);
		gridPane.add(new Label("BPG"), 7, 1);
		gridPane.add(new Label("SPG"), 8, 1);
		gridPane.add(new Label("TOPG"), 9, 1);
		
		
		populatePlayerStats(playerTotals, allTimePlayerTotals, primaryStage);
		
		
		playerStatsDisplayScene = new Scene(gridPane, 600, 300);
		primaryStage.setScene(playerStatsDisplayScene);
	}
	
	public static Scene getScene(Stage primaryStage, ArrayList<Player> playerTotals, Player allTimePlayerTotals, String name) {
		gridPane.getChildren().clear();
		gridPane.add(new Label("Player Statistics for "+name+": "), 0, 0);
		gridPane.add(new Label("Year"), 0, 1);
		gridPane.add(new Label("Games"), 1, 1);
		gridPane.add(new Label("FGA"), 2, 1);
		gridPane.add(new Label("FG%"), 3, 1);
		gridPane.add(new Label("PPG"), 4, 1);
		gridPane.add(new Label("APG"), 5, 1);
		gridPane.add(new Label("RPG"), 6, 1);
		gridPane.add(new Label("BPG"), 7, 1);
		gridPane.add(new Label("SPG"), 8, 1);
		gridPane.add(new Label("TOPG"), 9, 1);
		
		
		populatePlayerStats(playerTotals, allTimePlayerTotals, primaryStage);
		return playerStatsDisplayScene;
	}
	
	private static void populatePlayerStats(ArrayList<Player> playerTotals, Player allTimePlayerTotals, Stage primaryStage) {
		int y=2;
		
		for (Player player : playerTotals) {
				
			gridPane.add(new Label(String.valueOf(player.getYear())), 0, y);
			gridPane.add(new Label(String.valueOf(player.getWins())), 1, y);
			gridPane.add(new Label(String.valueOf(player.getLosses())), 2, y);
			gridPane.add(new Label(String.format("%.2f", player.getFGPercentage())), 3, y);
			gridPane.add(new Label(String.format("%.2f", player.getPPG())), 4, y);
			gridPane.add(new Label(String.format("%.2f", player.getAPG())), 5, y);
			gridPane.add(new Label(String.format("%.2f", player.getRPG())), 6, y);
			gridPane.add(new Label(String.format("%.2f", player.getBPG())), 7, y);
			gridPane.add(new Label(String.format("%.2f", player.getSPG())), 8, y);
			gridPane.add(new Label(String.format("%.2f", player.getTOPG())), 9, y);
				
			y+=1;
		}
			
		gridPane.add(new Label("All-Time"), 0, y);
		gridPane.add(new Label(String.valueOf(allTimePlayerTotals.getWins())), 1, y);
		gridPane.add(new Label(String.valueOf(allTimePlayerTotals.getLosses())), 2, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getFGPercentage())), 3, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getPPG())), 4, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getAPG())), 5, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getRPG())), 6, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getBPG())), 7, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getSPG())), 8, y);
		gridPane.add(new Label(String.format("%.2f", allTimePlayerTotals.getTOPG())), 9, y);
			
		y++;
		gridPane.add(btHome, 4, y);
		btHome.setOnAction(e-> primaryStage.setScene(LoginAccepted.getScene()));
		
		
	}
}
