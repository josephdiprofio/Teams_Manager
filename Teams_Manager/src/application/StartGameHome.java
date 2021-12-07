package application;

import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartGameHome {
	static GridPane gridPane = new GridPane();
	static Scene startGameScene;
	static TextField tfOpponentTeam = new TextField();
	static Button btHome = new Button("Home");
	static Button btStart = new Button("Start");
	static ComboBox<String> teamOptions = new ComboBox<String>();
	static int sgCount=0;

	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Start Game Home"), 0, 0);
		
		gridPane.add(new Label("Select User Team:"), 0, 1);
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
		
		gridPane.add(new Label("Enter Opponent Team:"), 0, 2);
		gridPane.add(tfOpponentTeam, 1, 2);
		gridPane.add(btStart, 0, 3);
		gridPane.add(btHome, 1, 3);

		gridPane.setAlignment(Pos.CENTER);
		
		btStart.setOnAction(e -> startGame(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		startGameScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(startGameScene); 
	}
	
	public static Scene getScene() {
		return startGameScene;
	}
	
	private static void populateTeamOptions(ArrayList <String> teams) {
		for(String team: teams) {
			teamOptions.getItems().add(team);
		}
	}
	
	private static void startGame(Stage primaryStage) {
		String userTeamName= teamOptions.getValue();
		String opponentTeamName= tfOpponentTeam.getText();
		tfOpponentTeam.clear();
		Team userTeam;
		try {
			userTeam = TeamDBAccess.getTeam(userTeamName);
			userTeam.setPlayers(PlayerDBAccess.getPlayers(userTeamName));
			Game game=new Game(userTeam, opponentTeamName, Year.now().getValue());
			sgCount++;
			if (sgCount==1) {
				GameInterface.display(primaryStage, game);
			}
			else {
				primaryStage.setScene(GameInterface.getReloadedScene(primaryStage, game));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
