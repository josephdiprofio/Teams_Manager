package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private Button btLogin = new Button("Login");
	private Button btCreateAcct = new Button("Create Account");
	static Scene mainScene;
	int countL=0;
	int countC=0;
	@Override
	public void start(Stage primaryStage) {
	
		 GridPane gridPane = new GridPane();
		 gridPane.setVgap(5);
		 
		 gridPane.add(btLogin, 0, 0);
		 gridPane.add(btCreateAcct, 0, 1);
		 
		 gridPane.setAlignment(Pos.CENTER);
		 
		 btLogin.setOnAction(e-> login(primaryStage));
		 btCreateAcct.setOnAction(e-> createAcct(primaryStage));
		 
		 mainScene = new Scene(gridPane, 400, 250);
		 primaryStage.setTitle("Team Manager"); 
		 primaryStage.setScene(mainScene); 
		 primaryStage.show(); 
		 
	}
	
	private void login(Stage primaryStage) {
		countL++;
		if (countL==1) {
			Login.display(primaryStage);
		}
		else {
			primaryStage.setScene(Login.getScene());
		}
	}
	
	private void createAcct(Stage primaryStage) {
		countC++;
		if (countC==1) {
			CreateAccount.display(primaryStage);
		}
		else {
			primaryStage.setScene(CreateAccount.getScene());
		}
		
	}
	
	public static Scene getScene() {
		return mainScene;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		CoachAcctDBAccess.init();
		launch(args);
	}
}
