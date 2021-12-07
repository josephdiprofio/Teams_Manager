package application;

import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateAccount {
	static TextField tfUsername = new TextField();
	static TextField tfPassword = new TextField();
	static Button btCreate = new Button("Create Account");
	static Button btTryAgain = new Button("Try Again");
	static Button btHome = new Button("Home");
	static GridPane gridPane = new GridPane();
	static Scene createScene;
	static int countL=0;
	public static void display(Stage primaryStage) {
		gridPane.setHgap(1);
		gridPane.setVgap(5);
		
		gridPane.add(new Label("Username:"), 0, 0);
		gridPane.add(tfUsername, 1, 0);
		gridPane.add(new Label("Password:"), 0, 1);
		gridPane.add(tfPassword, 1, 1);
		gridPane.add(btCreate, 1, 2);
		gridPane.add(btHome, 0, 2);
		
		btCreate.setOnAction(e -> validateCreation(primaryStage));
		btHome.setOnAction(e -> primaryStage.setScene(Main.getScene()));
		
		gridPane.setAlignment(Pos.CENTER);
		
		createScene = new Scene(gridPane, 400, 250);
		primaryStage.setScene(createScene); 
		
	}
	
	public static Scene getScene() {
		return createScene;
	}
	
	private static void validateCreation(Stage primaryStage) {
		String username= tfUsername.getText();
		String password= tfPassword.getText();
		
		boolean accountExists;
		
		try {
			accountExists = CoachAcctDBAccess.authenticate(username, password);
			tfUsername.clear();
			tfPassword.clear();
			gridPane.getChildren().clear();
			if (accountExists==true) {
				gridPane.add(new Label("Account Already Exists!"), 0, 0);
				gridPane.add(btTryAgain, 0, 1);
				btTryAgain.setOnAction(e -> tryAgain(primaryStage));
			}
			else {
				gridPane.add(new Label("Account Created Sucessfully."), 0, 0);
				CoachAcctDBAccess.addAccount(username, password);
				gridPane.add(btHome, 0, 1);
				btHome.setOnAction(e -> primaryStage.setScene(Main.getScene()));
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
		gridPane.add(btCreate, 1, 2);
		
		btCreate.setOnAction(e -> validateCreation(primaryStage));
		
	}
}
