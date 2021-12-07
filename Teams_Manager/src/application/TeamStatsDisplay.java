package application;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TeamStatsDisplay {
	static GridPane gridPane = new GridPane();
	static Scene teamStatsDisplayScene;
	static Button btHome= new Button("Home");
	public static void display(Stage primaryStage, Team team) {
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Team Statistics for "+team.getName()+": "), 0, 0);
		gridPane.add(new Label("Year"), 0, 1);
		gridPane.add(new Label("Wins"), 1, 1);
		gridPane.add(new Label("Losses"), 2, 1);
		gridPane.add(new Label("FG%"), 3, 1);
		gridPane.add(new Label("PPG"), 4, 1);
		gridPane.add(new Label("APG"), 5, 1);
		gridPane.add(new Label("RPG"), 6, 1);
		gridPane.add(new Label("BPG"), 7, 1);
		gridPane.add(new Label("SPG"), 8, 1);
		gridPane.add(new Label("TOPG"), 9, 1);
		gridPane.add(new Label("PAPG"), 10, 1);
		gridPane.add(new Label("MOV"), 11, 1);
		
		
		populateTeamStats(team, primaryStage);
		
		
		teamStatsDisplayScene = new Scene(gridPane, 600, 300);
		primaryStage.setScene(teamStatsDisplayScene);
		
	}
	
	public static Scene getScene(Stage primaryStage, Team team) {
		gridPane.getChildren().clear();
		gridPane.add(new Label("Team Statistics for "+team.getName()+": "), 0, 0);
		gridPane.add(new Label("Year"), 0, 1);
		gridPane.add(new Label("Wins"), 1, 1);
		gridPane.add(new Label("Losses"), 2, 1);
		gridPane.add(new Label("FG%"), 3, 1);
		gridPane.add(new Label("PPG"), 4, 1);
		gridPane.add(new Label("APG"), 5, 1);
		gridPane.add(new Label("RPG"), 6, 1);
		gridPane.add(new Label("BPG"), 7, 1);
		gridPane.add(new Label("SPG"), 8, 1);
		gridPane.add(new Label("TOPG"), 9, 1);
		gridPane.add(new Label("PAPG"), 10, 1);
		gridPane.add(new Label("MOV"), 11, 1);
		
		populateTeamStats(team, primaryStage);
		return teamStatsDisplayScene;
	}
	
	private static void populateTeamStats(Team team, Stage primaryStage) {
		int y=2;
		try {
			ArrayList<TeamTotals> userYearly= TeamsDataDBAccess.getYearlyTotals(team);
			TeamTotals allTime= TeamsDataDBAccess.getAllTimeTotals(team);
			
			for (TeamTotals totals: userYearly) {
				
				
				gridPane.add(new Label(String.valueOf(totals.getYear())), 0, y);
				gridPane.add(new Label(String.valueOf(totals.getWins())), 1, y);
				gridPane.add(new Label(String.valueOf(totals.getLosses())), 2, y);
				gridPane.add(new Label(String.format("%.2f", totals.getFGPercentage())), 3, y);
				gridPane.add(new Label(String.format("%.2f", totals.getPPG())), 4, y);
				gridPane.add(new Label(String.format("%.2f", totals.getAPG())), 5, y);
				gridPane.add(new Label(String.format("%.2f", totals.getRPG())), 6, y);
				gridPane.add(new Label(String.format("%.2f", totals.getBPG())), 7, y);
				gridPane.add(new Label(String.format("%.2f", totals.getSPG())), 8, y);
				gridPane.add(new Label(String.format("%.2f", totals.getTOPG())), 9, y);
				gridPane.add(new Label(String.format("%.2f", totals.getPAPG())), 10, y);
				gridPane.add(new Label(String.format("%.2f", totals.getMOV())), 11, y);
				
				y+=1;
			}
			
			gridPane.add(new Label("All-Time"), 0, y);
			gridPane.add(new Label(String.valueOf(allTime.getWins())), 1, y);
			gridPane.add(new Label(String.valueOf(allTime.getLosses())), 2, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getFGPercentage())), 3, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getPPG())), 4, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getAPG())), 5, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getRPG())), 6, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getBPG())), 7, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getSPG())), 8, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getTOPG())), 9, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getPAPG())), 10, y);
			gridPane.add(new Label(String.format("%.2f", allTime.getMOV())), 11, y);
			
			y++;
			gridPane.add(btHome, 4, y);
			btHome.setOnAction(e-> primaryStage.setScene(LoginAccepted.getScene()));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
