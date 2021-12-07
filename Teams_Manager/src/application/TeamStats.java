package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TeamStats {
	static GridPane gridPane = new GridPane();
	static Scene teamStatsScene;
	static ComboBox<String> teamOptions = new ComboBox<String>();
	static Button btHome = new Button("Home");
	static Button btSearch = new Button("Search");
	
	static int dtsCount=0;
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Get Team Statistics"), 0, 0);
		gridPane.add(new Label("Team to Get Statistics for:"), 0, 1);
		gridPane.add(teamOptions, 1, 1);
		try {
			ArrayList<String> teams= TeamDBAccess.getTeams(Login.getUsername());
			if (teams != null) {
				populateTeamOptions(teams);
			}
			else {
				teamOptions.getItems().add("No Teams, Create One First.");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		gridPane.add(btHome, 0, 2);
		gridPane.add(btSearch, 1, 2);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btSearch.setOnAction(e -> search(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		teamStatsScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(teamStatsScene); 
	}
	
	public static Scene getScene() {
		return teamStatsScene;
	}
	
	private static void search(Stage primaryStage) {
		String userTeamName=teamOptions.getValue();
		Team userTeam;
		try {
			userTeam = TeamDBAccess.getTeam(userTeamName);
			userTeam.setPlayers(PlayerDBAccess.getPlayers(userTeamName));
			dtsCount++;
			if (dtsCount==1) {
				TeamStatsDisplay.display(primaryStage, userTeam);
			}
			else {
				primaryStage.setScene(TeamStatsDisplay.getScene(primaryStage, userTeam));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void populateTeamOptions(ArrayList <String> teams) {
		for(String team: teams) {
			teamOptions.getItems().add(team);
		}
	}
}
