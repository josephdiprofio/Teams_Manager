package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginAccepted {
	static Button btAddPlayer = new Button("Add a Player");
	static Button btTeamStats = new Button("Get Team Statistics");
	static Button btPlayerStats = new Button("Get Player Statistics");
	static Button btAddTeam = new Button("Add Team");
	static Button btStartGame = new Button("Start Game");
	static Button btGameLog = new Button("Game Log");
	static Button btEditAccount = new Button("Edit Account");
	static Button btHome = new Button("Logout");
	static GridPane gridPane = new GridPane();
	static Scene loginAcceptedScene;
	static int apCount=0;
	static int tsCount=0;
	static int psCount=0;
	static int atCount=0;
	static int sgCount=0;
	static int eaCount=0;
	static int glCount=0;
	public static void display(Stage primaryStage) {
		gridPane.setHgap(0);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Home Screen"), 0, 0);
		gridPane.add(btAddPlayer, 0, 1);
		gridPane.add(btTeamStats, 0, 2);
		gridPane.add(btPlayerStats, 0, 3);
		gridPane.add(btAddTeam, 0, 4);
		gridPane.add(btStartGame, 0, 5);
		gridPane.add(btGameLog, 0, 6);
		gridPane.add(btEditAccount, 0, 7);	
		gridPane.add(btHome, 1, 7);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btAddPlayer.setOnAction(e -> DisplayAddPlayer(primaryStage));
		btTeamStats.setOnAction(e -> DisplayTeamStats(primaryStage));
		btPlayerStats.setOnAction(e -> DisplayPlayerStats(primaryStage));
		btAddTeam.setOnAction(e -> DisplayAddTeam(primaryStage));
		btStartGame.setOnAction(e -> DisplayStartGame(primaryStage));
		btGameLog.setOnAction(e -> DisplayGameLog(primaryStage));
		btEditAccount.setOnAction(e->DisplayEditAccount(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(Main.getScene()));
		
		loginAcceptedScene = new Scene(gridPane, 550, 300);
		primaryStage.setScene(loginAcceptedScene); 
	}
	
	private static void DisplayAddPlayer(Stage primaryStage) {
		apCount++;
		if (apCount==1) {
			AddPlayer.display(primaryStage);
		}
		else {
			primaryStage.setScene(AddPlayer.getScene());
		}
	}
	
	private static void DisplayTeamStats(Stage primaryStage) {
		tsCount++;
		if (tsCount==1) {
			TeamStats.display(primaryStage);
		}
		else {
			primaryStage.setScene(TeamStats.getScene());
		}
	}
	
	private static void DisplayPlayerStats(Stage primaryStage) {
		psCount++;
		if (psCount==1) {
			PlayerStats.display(primaryStage);
		}
		else {
			primaryStage.setScene(PlayerStats.getScene());
		}
	}
	
	private static void DisplayAddTeam(Stage primaryStage) {
		atCount++;
		if (atCount==1) {
			AddTeam.display(primaryStage);
		}
		else {
			primaryStage.setScene(AddTeam.getScene());
		}
	}
	
	private static void DisplayStartGame(Stage primaryStage) {
		sgCount++;
		if (sgCount==1) {
			StartGameHome.display(primaryStage);
		}
		else {
			primaryStage.setScene(StartGameHome.getScene());
		}
	}
	
	private static void DisplayGameLog(Stage primaryStage) {
		glCount++;
		if (glCount==1) {
			GameLog.display(primaryStage);
		}
		else {
			primaryStage.setScene(GameLog.getScene());
		}
	}
	
	private static void DisplayEditAccount(Stage primaryStage) {
		eaCount++;
		if (eaCount==1) {
			EditAccount.display(primaryStage);
		}
		else {
			primaryStage.setScene(EditAccount.getScene());
		}
	}
	
	public static Scene getScene() {
		return loginAcceptedScene;
	}
}
