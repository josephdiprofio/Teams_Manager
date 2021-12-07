package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddPlayer {
	static GridPane gridPane = new GridPane();
	static Scene addPlayerScene;
	static TextField tfName = new TextField();
	static ComboBox<String> teamOptions = new ComboBox<String>();
	static TextField tfHeight = new TextField();
	static TextField tfWeight = new TextField();
	static Button btHome = new Button("Home");
	static Button btAdd = new Button("Add");
	static Button btTryAgain = new Button("Try Again");
	
	
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Add Player"), 0, 0);
		gridPane.add(new Label("Name:"), 0, 1);
		gridPane.add(tfName, 1, 1);
		
		gridPane.add(new Label("Team: "), 0, 2);
		gridPane.add(teamOptions, 1, 2);
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
		
		gridPane.add(new Label("Height: "), 0, 3);
		gridPane.add(tfHeight, 1, 3);
		gridPane.add(new Label("Weight: "), 0, 4);
		gridPane.add(tfWeight, 1, 4);
		gridPane.add(btHome, 0, 5);
		gridPane.add(btAdd, 1, 5);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btAdd.setOnAction(e -> add(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		addPlayerScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(addPlayerScene); 
	}
	
	public static Scene getScene() {
		return addPlayerScene;
	}
	
	private static void add(Stage primaryStage) {
		String name= tfName.getText();
		String team= teamOptions.getValue();
		String height= tfHeight.getText();
		String weight= tfWeight.getText();
			
		Player player=new Player(name, team, height, weight);
		
		tfName.clear();
		teamOptions.getItems().clear();
		tfHeight.clear();
		tfWeight.clear();
		gridPane.getChildren().clear();
		try {
			boolean added = PlayerDBAccess.validateAdd(player);
			if (added) {
				gridPane.add(new Label("Player Added Successfully"), 0, 0);
				PlayerDBAccess.addPlayer(player);
				gridPane.add(btHome, 0, 1);
				btHome.setOnAction(e -> addSuccess(primaryStage));
			}
			else {
				gridPane.add(new Label("Player Exists Already"), 0, 0);
				gridPane.add(btTryAgain, 0, 1);
				btTryAgain.setOnAction(e -> tryAgain(primaryStage));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addSuccess(Stage primaryStage) {
		primaryStage.setScene(LoginAccepted.getScene());
		gridPane.getChildren().clear();
		repopulate(primaryStage);
	}
	
	private static void tryAgain(Stage primaryStage) {
		gridPane.getChildren().clear();
		repopulate(primaryStage);
	}
	
	private static void repopulate(Stage primaryStage) {
		gridPane.add(new Label("Add Player"), 0, 0);
		gridPane.add(new Label("Name:"), 0, 1);
		gridPane.add(tfName, 1, 1);
		
		gridPane.add(new Label("Team: "), 0, 2);
		gridPane.add(teamOptions, 1, 2);
		ArrayList<String> teams;
		try {
			teams = TeamDBAccess.getTeams(Login.getUsername());
			populateTeamOptions(teams);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		gridPane.add(new Label("Height: "), 0, 3);
		gridPane.add(tfHeight, 1, 3);
		gridPane.add(new Label("Weight: "), 0, 4);
		gridPane.add(tfWeight, 1, 4);
		gridPane.add(btHome, 0, 5);
		gridPane.add(btAdd, 1, 5);
		
		btAdd.setOnAction(e -> add(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
	}
	
	private static void populateTeamOptions(ArrayList <String> teams) {
		for(String team: teams) {
			teamOptions.getItems().add(team);
		}
	}
}
