package application;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameLogDisplay {
	static GridPane gridPane = new GridPane();
	static Scene GameLogDisplayScene;
	static Button btHome = new Button("Home");
	
	public static void display(Stage primaryStage, ArrayList<BoxScore> scores) {
		
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		
		gridPane.add(new Label("Game Log"), 0, 0);
		gridPane.add(new Label("User Team"), 1, 1);
		gridPane.add(new Label("User Score"), 2, 1);
		gridPane.add(new Label("Opponent Team"), 3, 1);
		gridPane.add(new Label("Opponent Score"), 4, 1);
		gridPane.add(new Label("Year"), 5, 1);
		
		populateGameLog(scores, primaryStage);
		
		gridPane.setAlignment(Pos.TOP_CENTER);
		
		GameLogDisplayScene = new Scene(gridPane, 500, 400);
		primaryStage.setScene(GameLogDisplayScene); 
	}
	
	public static Scene getScene(ArrayList<BoxScore> scores, Stage primaryStage) {
		gridPane.getChildren().clear();
		gridPane.add(new Label("Game Log"), 0, 0);
		gridPane.add(new Label("User Team"), 1, 1);
		gridPane.add(new Label("User Score"), 2, 1);
		gridPane.add(new Label("Opponent Team"), 3, 1);
		gridPane.add(new Label("Opponent Score"), 4, 1);
		gridPane.add(new Label("Year"), 5, 1);
		
		populateGameLog(scores, primaryStage);
		return GameLogDisplayScene;
	}
	
	private static void populateGameLog(ArrayList<BoxScore> scores, Stage primaryStage) {
		int y=2;
		for(BoxScore score: scores) {
			gridPane.add(new Label(score.getUserTeam()), 1, y);
			gridPane.add(new Label(String.valueOf(score.getUserScore())), 2, y);
			gridPane.add(new Label(score.getOppTeam()), 3, y);
			gridPane.add(new Label(String.valueOf(score.getOppScore())), 4, y);
			gridPane.add(new Label(String.valueOf(score.getYear())), 5, y);
			
			y++;
		}
		gridPane.add(btHome, 3, y);
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
	}
}
