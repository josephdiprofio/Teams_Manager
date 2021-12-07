package application;

import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
	static TextField tfUsername = new TextField();
	static TextField tfPassword = new TextField();
	static Button btLogin = new Button("Login");
	static Button btHome = new Button("Home");
	static Button btTryAgain = new Button("TryAgain");
	static GridPane gridPane = new GridPane();
	static Scene loginScene;
	static String username;
	static int countL=0;
	public static void display(Stage primaryStage) {
		
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Username:"), 0, 0);
		gridPane.add(tfUsername, 1, 0);
		gridPane.add(new Label("Password:"), 0, 1);
		gridPane.add(tfPassword, 1, 1);
		gridPane.add(btLogin, 1, 2);
		gridPane.add(btHome, 0, 2);
		
		gridPane.setAlignment(Pos.CENTER);
		
		btLogin.setOnAction(e -> authenticate(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(Main.getScene()));
		
		loginScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(loginScene); 
	}
	
	public static Scene getScene() {
		return loginScene;
	}
	
	private static void authenticate(Stage primaryStage) {
		username= tfUsername.getText();
		String password= tfPassword.getText();
		
		boolean authenticated;
		
		try {
			authenticated = CoachAcctDBAccess.authenticate(username, password);
			tfUsername.clear();
			tfPassword.clear();
			if (authenticated==false) {
				gridPane.getChildren().clear();
				gridPane.add(new Label("Username/Password Incorrect"), 0, 0);
				gridPane.add(btTryAgain, 0, 1);
				btTryAgain.setOnAction(e -> tryAgain(primaryStage));
			}
			else {
				countL++;
				if (countL==1) {
					LoginAccepted.display(primaryStage);
				}
				else {
					primaryStage.setScene(LoginAccepted.getScene());
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	private static void tryAgain(Stage primaryStage) {
		gridPane.getChildren().clear();
		repopulate(primaryStage);
	}
	
	private static void repopulate(Stage primaryStage) {
		gridPane.add(new Label("Username:"), 0, 0);
		gridPane.add(tfUsername, 1, 0);
		gridPane.add(new Label("Password:"), 0, 1);
		gridPane.add(tfPassword, 1, 1);
		gridPane.add(btLogin, 1, 2);
		
		btLogin.setOnAction(e -> authenticate(primaryStage));
		
	}
	
	public static String getUsername() {
		return username;
	}
}
