package application;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditAccount {
	static GridPane gridPane = new GridPane();
	static Scene editAccountScene;
	static TextField tfNewUsername = new TextField();
	static TextField tfNewPassword = new TextField();
	static Button btHome = new Button("Home");
	static Button btUpdate= new Button("Update");
	static Button btTryAgain= new Button("Try Again");
	
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Edit Account"), 0, 0);
		gridPane.add(new Label("New Username:"), 0, 1);
		gridPane.add(tfNewUsername, 1, 1);
		gridPane.add(new Label("New Password"), 0, 2);
		gridPane.add(tfNewPassword, 1, 2);
		gridPane.add(btHome, 0, 3);
		gridPane.add(btUpdate, 1, 3);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btUpdate.setOnAction(e -> update(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
		
		editAccountScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(editAccountScene); 
	}
	
	public static Scene getScene() {
		return editAccountScene;
	}
	
	private static void tryAgain(Stage primaryStage) {
		gridPane.getChildren().clear();
		repopulate(primaryStage);
	}
	
	private static void repopulate(Stage primaryStage) {
		gridPane.add(new Label("Edit Account"), 0, 0);
		gridPane.add(new Label("New Username:"), 0, 1);
		gridPane.add(tfNewUsername, 1, 1);
		gridPane.add(new Label("New Password"), 0, 2);
		gridPane.add(tfNewPassword, 1, 2);
		gridPane.add(btHome, 0, 3);
		gridPane.add(btUpdate, 1, 3);
		
		btUpdate.setOnAction(e -> update(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(LoginAccepted.getScene()));
	}
	
	private static void update(Stage primaryStage) {
		String newUsername= tfNewUsername.getText();
		String newPassword= tfNewPassword.getText();
		
		try {
			tfNewUsername.clear();
			tfNewPassword.clear();
			gridPane.getChildren().clear();
			int result= CoachAcctDBAccess.update(Login.getUsername(), newUsername, newPassword);
			
			if(result>0) {
				gridPane.add(new Label("Account Updated."), 0, 0);
				gridPane.add(btHome, 0, 1);
				btHome.setOnAction(e -> primaryStage.setScene(Main.getScene()));
			}
			else {
				gridPane.add(new Label("Update Failed!"), 0, 0);
				gridPane.add(btTryAgain, 0, 1);
				btTryAgain.setOnAction(e -> tryAgain(primaryStage));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
