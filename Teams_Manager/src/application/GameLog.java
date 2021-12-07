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

public class GameLog {
	static GridPane gridPane = new GridPane();
	static Scene GameLogScene;
	static ComboBox<String> teamOptions = new ComboBox<String>();
	static Button btSearch = new Button("Search");
	
	static int glCount=0;
	
	public static void display(Stage primaryStage) {
		
		gridPane.add(new Label("Select User Team:"), 0, 0);
		gridPane.add(teamOptions, 1, 0);
		try {
			ArrayList<String> teams= TeamDBAccess.getTeams(Login.getUsername());
			if (teams != null) {
				populateTeamOptions(teams);
			}
			else {
				teamOptions.getItems().add("No Teams, Create One First.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		gridPane.add(btSearch, 0, 1);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btSearch.setOnAction(e -> search(primaryStage));
		
		GameLogScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(GameLogScene); 
	}
	
	public static Scene getScene() {
		return GameLogScene;
	}
	
	private static void populateTeamOptions(ArrayList <String> teams) {
		for(String team: teams) {
			teamOptions.getItems().add(team);
		}
	}
	
	private static void search(Stage primaryStage) {
		String userTeamName=teamOptions.getValue();
		ArrayList<BoxScore> scores;
		try {
			scores = GameLogDBAccess.getScores(userTeamName);
			glCount++;
			if (glCount==1) {
				GameLogDisplay.display(primaryStage, scores);
			}
			else {
				primaryStage.setScene(GameLogDisplay.getScene(scores, primaryStage));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
