package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerStats {
	static GridPane gridPane = new GridPane();
	static Scene playerStatsScene;
	static TextField tfPlayer = new TextField();
	static Button btHome = new Button("Home");
	static Button btSearch = new Button("Search");
	
	static int sCount=0;
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Get Player Statistics"), 0, 0);
		gridPane.add(new Label("Player to Get Statistics for:"), 0, 1);
		gridPane.add(tfPlayer, 1, 1);
		gridPane.add(btHome, 0, 2);
		gridPane.add(btSearch, 1, 2);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btSearch.setOnAction(e -> search(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		playerStatsScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(playerStatsScene); 
	}
	
	public static Scene getScene() {
		tfPlayer.clear();
		gridPane.getChildren().clear();
		gridPane.add(new Label("Get Player Statistics"), 0, 0);
		gridPane.add(new Label("Player to Get Statistics for:"), 0, 1);
		gridPane.add(tfPlayer, 1, 1);
		gridPane.add(btHome, 0, 2);
		gridPane.add(btSearch, 1, 2);
		return playerStatsScene;
	}
	
	private static void search(Stage primaryStage) {
		String name=tfPlayer.getText();
		ArrayList<Player> playerTotals;
		Player allTimePlayerTotals;
		try {
			playerTotals=PlayerDBAccess.getPlayerTotals(name);
			allTimePlayerTotals=PlayerDBAccess.getAllTimePlayerTotals(name);
			if (playerTotals==null || allTimePlayerTotals==null) {
				gridPane.getChildren().clear();
				gridPane.add(new Label("Player Does Not Exist."), 0, 0);
				gridPane.add(btHome, 0, 2);
				
			}
			else {
				sCount++;
				if (sCount==1) {
					PlayerStatsDisplay.display(primaryStage, playerTotals, allTimePlayerTotals, name);
				}
				else {
					primaryStage.setScene(PlayerStatsDisplay.getScene(primaryStage, playerTotals, allTimePlayerTotals, name));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
