package application;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddTeam {
	static GridPane gridPane = new GridPane();
	static Scene addTeamScene;
	static TextField tfTeamName = new TextField();
	static ComboBox<String> coachSelect = new ComboBox<String>();
	static TextField tfCity = new TextField();
	static TextField tfState = new TextField();
	static Button btHome = new Button("Home");
	static Button btAdd= new Button("Add");
	static Button btTryAgain = new Button("Try Again");
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Add Team"), 0, 0);
		gridPane.add(new Label("Team Name:"), 0, 1);
		gridPane.add(tfTeamName, 1, 1);
		gridPane.add(new Label("Coach Username:"), 0, 2);
		
		gridPane.add(coachSelect, 1, 2);
		coachSelect.getItems().add(Login.getUsername());
		
		gridPane.add(new Label("State:"), 0, 3);
		gridPane.add(tfState, 1, 3);
		gridPane.add(new Label("City:"), 0, 4);
		gridPane.add(tfCity, 1, 4);
		gridPane.add(btAdd, 0, 5);
		gridPane.add(btHome, 1, 5);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btAdd.setOnAction(e -> add(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		addTeamScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(addTeamScene); 
	}
	
	public static Scene getScene() {
		return addTeamScene;
	}
	
	private static void add(Stage primaryStage) {
		String teamName= tfTeamName.getText();
		String coach= coachSelect.getValue();
		String state= tfState.getText();
		String city= tfCity.getText();
		
		Team team= new Team(teamName, coach, state, city);
		
		tfTeamName.clear();
		tfState.clear();
		tfCity.clear();
		coachSelect.getItems().clear();
		gridPane.getChildren().clear();
		try {
			boolean added = TeamDBAccess.validateAdd(team);
			if (added) {
				gridPane.add(new Label("Team Added Successfully"), 0, 0);
				TeamDBAccess.addTeam(team);
				gridPane.add(btHome, 0, 1);
				btHome.setOnAction(e -> addSuccess(primaryStage));
			}
			else {
				gridPane.add(new Label("Team Exists Already"), 0, 0);
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
		gridPane.add(new Label("Add Team"), 0, 0);
		gridPane.add(new Label("Team Name:"), 0, 1);
		gridPane.add(tfTeamName, 1, 1);
		gridPane.add(new Label("Coach Username:"), 0, 2);
		
		gridPane.add(coachSelect, 1, 2);
		coachSelect.getItems().add(Login.getUsername());
		
		gridPane.add(new Label("State:"), 0, 3);
		gridPane.add(tfState, 1, 3);
		gridPane.add(new Label("City:"), 0, 4);
		gridPane.add(tfCity, 1, 4);
		gridPane.add(btAdd, 0, 5);
		gridPane.add(btHome, 1, 5);
		
		btAdd.setOnAction(e -> add(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
	}
}
