package application;


import java.util.ArrayList;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerSelect {
	static GridPane gridPane = new GridPane();
	static Scene displayPlayersScene;
	static ComboBox<String> playerOptions = new ComboBox<String>();
	static Button btSelect = new Button("Select");
	static Button btCancel = new Button("Cancel");
	public static void display(Stage primaryStage, Game game) {
		ArrayList<Player> players= game.getUserTeam().getPlayers();
		gridPane.add(playerOptions, 0, 0);
		for(Player player: players) {
			playerOptions.getItems().add(player.getName());
		}
		
		gridPane.add(btSelect, 0, 1);
		gridPane.add(btCancel, 1, 1);
		gridPane.setAlignment(Pos.CENTER);
		
		btSelect.setOnAction(e -> getSelection(primaryStage));
		btCancel.setOnAction(e -> primaryStage.setScene(GameInterface.getScene()));
		
		displayPlayersScene = new Scene(gridPane, 350, 400);
		primaryStage.setScene(displayPlayersScene);
		
	}
	
	private static void getSelection(Stage primaryStage) {
		String selection= playerOptions.getValue();
		CurrentPlayerSelection selected= CurrentPlayerSelection.getInstance();
		selected.setSelection(selection);
		primaryStage.setScene(GameInterface.getScene());
	}
	
	public static Scene getScene(Game game) {
		playerOptions.getItems().removeAll(playerOptions.getItems());
		gridPane.getChildren().clear();
		ArrayList<Player> players= game.getUserTeam().getPlayers();
		gridPane.add(playerOptions, 0, 0);
		for(Player player: players) {
			playerOptions.getItems().add(player.getName());
		}
		gridPane.add(btSelect, 0, 1);
		gridPane.add(btCancel, 1, 1);
		return displayPlayersScene;
	}
}
