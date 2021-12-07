package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameInterface {
	static BorderPane borderPane = new BorderPane();
	static GridPane topGridPane = new GridPane();
	static GridPane leftGridPane = new GridPane();
	static GridPane rightGridPane = new GridPane();
	static GridPane centerGridPane = new GridPane();
	static GridPane bottomGridPane = new GridPane();
	static Scene gameInterfaceScene;
	
	static Label userScore= new Label("");
	static Label oppScore= new Label("");
	static Label userTFouls= new Label("");
	static Label oppTFouls= new Label("");
	static Label userTimeouts= new Label("");
	static Label oppTimeouts= new Label("");
	
	static Button btU1Basket = new Button("1 Point");
	static Button btU2Basket = new Button("2 Points");
	static Button btU3Basket = new Button("3 Points");
	static Button btUTeamFoul = new Button("Team Foul");
	static Button btUTimeout = new Button("Timeout");
	static Button btUTurnover = new Button("Turnover");
	static Button btUBlock = new Button("Block");
	static Button btUAssist = new Button("Assist");
	static Button btUSteal = new Button("Steal");
	static Button btUMissedShot = new Button("Missed Shot");
	static Button btURebound = new Button("Rebound");
	
	static Button btO1Basket = new Button("1 Point");
	static Button btO2Basket = new Button("2 Points");
	static Button btO3Basket = new Button("3 Points");
	static Button btOTeamFoul = new Button("Team Foul");
	static Button btOTimeout = new Button("Timeout");
	static Button btOTurnover = new Button("Turnover");
	static Button btOBlock = new Button("Block");
	static Button btOAssist = new Button("Assist");
	static Button btOSteal = new Button("Steal");
	static Button btOMissedShot = new Button("Missed Shot");
	static Button btORebound = new Button("Rebound");
	
	static Button btEndGame = new Button("End Game");
	static Button btApply = new Button("Apply");
	
	static int dpCount=0, dtoCount=0, listUpdateCount=0;
	public static void display(Stage primaryStage, Game game) {
		
		
		//Top 
		topGridPane.setHgap(3);
		topGridPane.setVgap(5);
		
		topGridPane.add(new Label(game.getUserTeam().getName()), 0, 1);
		topGridPane.add(userScore, 1, 1);
		topGridPane.add(new Label("Team Fouls: "), 0, 2);
		topGridPane.add(userTFouls, 1, 2);
		topGridPane.add(new Label("Timeouts Taken: "), 0, 3);
		topGridPane.add(userTimeouts, 1, 3);
		
		topGridPane.add(new Label(game.getOppTeam()), 5, 1);
		topGridPane.add(oppScore, 6, 1);
		topGridPane.add(new Label("Team Fouls: "), 5, 2);
		topGridPane.add(oppTFouls, 6, 2);
		topGridPane.add(new Label("Timouts Taken: "), 5, 3);
		topGridPane.add(oppTimeouts, 6, 3);
		
		topGridPane.setAlignment(Pos.CENTER);
		
		
		
		//left
		leftGridPane.setVgap(5);
		
		leftGridPane.add(new Label("User Team: "), 0, 3);
		leftGridPane.add(btU1Basket, 0, 4);
		leftGridPane.add(btU2Basket, 0, 5);
		leftGridPane.add(btU3Basket, 0, 6);
		leftGridPane.add(btUTeamFoul, 0, 7);
		leftGridPane.add(btUTimeout, 0, 8);
		leftGridPane.add(btUTurnover, 0, 9);
		leftGridPane.add(btUBlock, 0, 10);
		leftGridPane.add(btUAssist, 0, 11);
		leftGridPane.add(btUSteal, 0, 12);
		leftGridPane.add(btUMissedShot, 0, 13);
		leftGridPane.add(btURebound, 0, 14);
		
		//Right
		rightGridPane.setVgap(5);
		
		rightGridPane.add(new Label("Opponent Team: "), 0, 3);
		rightGridPane.add(btO1Basket, 0, 4);
		rightGridPane.add(btO2Basket, 0, 5);
		rightGridPane.add(btO3Basket, 0, 6);
		rightGridPane.add(btOTeamFoul, 0, 7);
		rightGridPane.add(btOTimeout, 0, 8);
		rightGridPane.add(btOTurnover, 0, 9);
		rightGridPane.add(btOBlock, 0, 10);
		rightGridPane.add(btOAssist, 0, 11);
		rightGridPane.add(btOSteal, 0, 12);
		rightGridPane.add(btOMissedShot, 0, 13);
		rightGridPane.add(btORebound, 0, 14);
		
		//Center
		centerGridPane.setHgap(3);
		centerGridPane.setVgap(5);
		
		centerGridPane.add(new Label("User Team Statistics: "), 5, 3);
		centerGridPane.add(new Label("Name"), 5, 4);
		centerGridPane.add(new Label("Points"), 30, 4);
		centerGridPane.add(new Label("Assists"), 35, 4);
		centerGridPane.add(new Label("Rebounds"), 40, 4);
		centerGridPane.add(new Label("Blocks"), 45, 4);
		centerGridPane.add(new Label("Steals"), 50, 4);
		centerGridPane.add(new Label("Fouls"), 55, 4);
		centerGridPane.add(new Label("Rebounds"), 60, 4);
		
		//bottom
		bottomGridPane.add(btEndGame, 0, 0);
		bottomGridPane.setAlignment(Pos.CENTER);
		
		//button functionality
		btU1Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Upoint"));
		btU2Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "U2point"));
		btU3Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "U3point"));
		btUTeamFoul.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Ufoul"));
		btUTimeout.setOnAction(e -> update("Utimeout", game));
		btUTurnover.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Uturnover"));
		btUBlock.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Ublock"));
		btUAssist.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Uassist"));
		btUSteal.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Usteal"));
		btUMissedShot.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Umissed"));
		btURebound.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Urebound"));
		
		btO1Basket.setOnAction(e -> update("Opoint", game));
		btO2Basket.setOnAction(e -> update("O2point", game));
		btO3Basket.setOnAction(e -> update("O3point", game));
		btOTeamFoul.setOnAction(e -> update("Ofoul", game));
		btOTimeout.setOnAction(e -> update("Otimeout", game));
		btOTurnover.setOnAction(e -> update("Oturnover", game));
		btOBlock.setOnAction(e -> update("Oblock", game));
		btOAssist.setOnAction(e -> update("Oassist", game));
		btOSteal.setOnAction(e -> update("Osteal", game));
		btOMissedShot.setOnAction(e -> update("Omissed", game));
		btORebound.setOnAction(e -> update("Orebound", game));
		
		btEndGame.setOnAction(e -> endGame(primaryStage, game));
		
		
		//adding gridPanes to borderPane
		borderPane.setTop(topGridPane);
		borderPane.setLeft(leftGridPane);
		borderPane.setRight(rightGridPane);
		borderPane.setCenter(centerGridPane);
		borderPane.setBottom(bottomGridPane);
		
		gameInterfaceScene = new Scene(borderPane, 800, 500);
		primaryStage.setScene(gameInterfaceScene);
	}
	
	public static Scene getScene() {
		return gameInterfaceScene;
	}
	
	public static Scene getReloadedScene(Stage primaryStage, Game game) {
		userScore.setText("");
		oppScore.setText("");
		userTFouls.setText("");
		oppTFouls.setText("");
		userTimeouts.setText("");
		oppTimeouts.setText("");
		topGridPane.getChildren().clear();
		centerGridPane.getChildren().clear();
		
		//top
		topGridPane.add(new Label(game.getUserTeam().getName()), 0, 1);
		topGridPane.add(userScore, 1, 1);
		topGridPane.add(new Label("Team Fouls: "), 0, 2);
		topGridPane.add(userTFouls, 1, 2);
		topGridPane.add(new Label("Timeouts Taken: "), 0, 3);
		topGridPane.add(userTimeouts, 1, 3);
		
		topGridPane.add(new Label(game.getOppTeam()), 5, 1);
		topGridPane.add(oppScore, 6, 1);
		topGridPane.add(new Label("Team Fouls: "), 5, 2);
		topGridPane.add(oppTFouls, 6, 2);
		topGridPane.add(new Label("Timouts Taken: "), 5, 3);
		topGridPane.add(oppTimeouts, 6, 3);
		
		//center
		centerGridPane.add(new Label("User Team Statistics: "), 5, 3);
		centerGridPane.add(new Label("Name"), 5, 4);
		centerGridPane.add(new Label("Points"), 30, 4);
		centerGridPane.add(new Label("Assists"), 35, 4);
		centerGridPane.add(new Label("Rebounds"), 40, 4);
		centerGridPane.add(new Label("Blocks"), 45, 4);
		centerGridPane.add(new Label("Steals"), 50, 4);
		centerGridPane.add(new Label("Fouls"), 55, 4);
		centerGridPane.add(new Label("Rebounds"), 60, 4);
		
		btU1Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Upoint"));
		btU2Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "U2point"));
		btU3Basket.setOnAction(e -> displayPlayerSelect(primaryStage, game, "U3point"));
		btUTeamFoul.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Ufoul"));
		btUTimeout.setOnAction(e -> update("Utimeout", game));
		btUTurnover.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Uturnover"));
		btUBlock.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Ublock"));
		btUAssist.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Uassist"));
		btUSteal.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Usteal"));
		btUMissedShot.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Umissed"));
		btURebound.setOnAction(e -> displayPlayerSelect(primaryStage, game, "Urebound"));
		
		btO1Basket.setOnAction(e -> update("Opoint", game));
		btO2Basket.setOnAction(e -> update("O2point", game));
		btO3Basket.setOnAction(e -> update("O3point", game));
		btOTeamFoul.setOnAction(e -> update("Ofoul", game));
		btOTimeout.setOnAction(e -> update("Otimeout", game));
		btOTurnover.setOnAction(e -> update("Oturnover", game));
		btOBlock.setOnAction(e -> update("Oblock", game));
		btOAssist.setOnAction(e -> update("Oassist", game));
		btOSteal.setOnAction(e -> update("Osteal", game));
		btOMissedShot.setOnAction(e -> update("Omissed", game));
		btORebound.setOnAction(e -> update("Orebound", game));
		
		btEndGame.setOnAction(e -> endGame(primaryStage, game));
		
		return gameInterfaceScene;
	}
	 
	private static void displayPlayerSelect(Stage primaryStage, Game game, String action) {
		dpCount++;
		
			if (dpCount==1) {
				bottomGridPane.add(btApply, 1, 0);
				PlayerSelect.display(primaryStage, game);
			}
			else {
				primaryStage.setScene(PlayerSelect.getScene(game));
			}
			btApply.setOnAction(e -> update(action, game));	
	}
	
	
	private static void endGame(Stage primaryStage, Game game) {
		try {
			if(game.getUserScore()>game.getOppScore()) {
				game.incUserWin();
			}
			else {
				game.incUserLoss();
			}
			EndGameDBAccess.endGame(game);
			primaryStage.setScene(LoginAccepted.getScene());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void update(String action, Game game) {
		
		CurrentPlayerSelection select=CurrentPlayerSelection.getInstance();
		ArrayList<Player> players= game.getUserTeam().getPlayers();
		
		//user team actions
		if (action.equals("Upoint")) {
			game.inc1UserScore();
			game.incUserMadeShots();
			userScore.setText(String.valueOf(game.getUserScore()));
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.inc1Point();
					player.incMadeShots();
				}
			}
		}
		
		if(action.equals("U2point")) {
			game.inc2UserScore();
			game.incUserMadeShots();
			userScore.setText(String.valueOf(game.getUserScore()));
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.inc2Points();
					player.incMadeShots();
				}
			}
		}
		
		if(action.equals("U3point")) {
			game.inc3UserScore();
			game.incUserMadeShots();
			userScore.setText(String.valueOf(game.getUserScore()));
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.inc3Points();
					player.incMadeShots();
				}
			}
		}
		
		if(action.equals("Ufoul")) {
			game.incUserFouls();
			userTFouls.setText(String.valueOf(game.getUserTFouls()));
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incFouls();
				}
			}
		}
		
		if(action.equals("Uturnover")) {
			game.incUserTurnover();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incTurnovers();
				}
			}
		}
		
		if(action.equals("Ublock")) {
			game.incUserBlocks();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incBlocks();
				}
			}
		}
		
		if(action.equals("Uassist")) {
			game.incUserAssists();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incAssists();
				}
			}
		}
		
		if(action.equals("Usteal")) {
			game.incUserSteals();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incSteals();
				}
			}
		}
		
		if(action.equals("Umissed")) {
			game.incUserMissedShots();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incMissedShots();
				}
			}
		}
		
		if(action.equals("Utimeout")) {
			game.incUserTimeouts();
			userTimeouts.setText(String.valueOf(game.getUserTimeouts()));
		}
		
		if(action.equals("Urebound")) {
			game.incUserRebounds();
			for(Player player: players) {
				if(player.getName().equals(select.getSelection())) {
					player.incRebounds();;
				}
			}
		}
		
		//opp team actions
		if (action.equals("Opoint")) {
			game.inc1OppScore();
			game.incOppMadeShots();
			oppScore.setText(String.valueOf(game.getOppScore()));
		}
		if(action.equals("O2point")) {
			game.inc2OppScore();
			game.incOppMadeShots();
			oppScore.setText(String.valueOf(game.getOppScore()));
		}
		if(action.equals("O3point")) {
			game.inc3OppScore();
			game.incOppMadeShots();
			oppScore.setText(String.valueOf(game.getOppScore()));
		}
		if(action.equals("Ofoul")) {
			game.incOppFouls();
			oppTFouls.setText(String.valueOf(game.getOppTFouls()));
		}
		if(action.equals("Oturnover")) {
			game.incOppTurnovers();
		}
		if(action.equals("Oblock")) {
			game.incOppBlocks();
		}
		if(action.equals("Oassist")) {
			game.incOppAssists();
		}
		if(action.equals("Osteal")) {
			game.incOppSteals();
		}
		if(action.equals("Omissed")) {
			game.incOppMissedShots();
		}
		if(action.equals("Otimeout")) {
			game.incOppTimeouts();
			oppTimeouts.setText(String.valueOf(game.getOppTimeouts()));
		}
		if(action.equals("Orebound")) {
			game.incOppRebounds();
		}
		
		updateAndPopulateUserPlayerStats(game);
	}
	
	private static void updateAndPopulateUserPlayerStats(Game game) {
		ArrayList<Player> players= game.getUserTeam().getPlayers();
		int y=5;
		listUpdateCount++;
		if(listUpdateCount==1) {
			for (Player player : players) {
				centerGridPane.add(new Label(player.getName()), 5, y);
				centerGridPane.add(new Label(String.valueOf(player.getPoints())), 30, y);
				centerGridPane.add(new Label(String.valueOf(player.getAssists())), 35, y);
				centerGridPane.add(new Label(String.valueOf(player.getRebounds())), 40, y);
				centerGridPane.add(new Label(String.valueOf(player.getBlocks())), 45, y);
				centerGridPane.add(new Label(String.valueOf(player.getSteals())), 50, y);
				centerGridPane.add(new Label(String.valueOf(player.getFouls())), 55, y);
				centerGridPane.add(new Label(String.valueOf(player.getRebounds())), 60, y);
			
				y+=1;
			}
		}
		else {
			centerGridPane.getChildren().clear();
			centerGridPane.add(new Label("User Team Statistics: "), 5, 3);
			centerGridPane.add(new Label("Name"), 5, 4);
			centerGridPane.add(new Label("Points"), 30, 4);
			centerGridPane.add(new Label("Assists"), 35, 4);
			centerGridPane.add(new Label("Rebounds"), 40, 4);
			centerGridPane.add(new Label("Blocks"), 45, 4);
			centerGridPane.add(new Label("Steals"), 50, 4);
			centerGridPane.add(new Label("Fouls"), 55, 4);
			centerGridPane.add(new Label("Rebounds"), 60, 4);
			
			for (Player player : players) {
				centerGridPane.add(new Label(player.getName()), 5, y);
				centerGridPane.add(new Label(String.valueOf(player.getPoints())), 30, y);
				centerGridPane.add(new Label(String.valueOf(player.getAssists())), 35, y);
				centerGridPane.add(new Label(String.valueOf(player.getRebounds())), 40, y);
				centerGridPane.add(new Label(String.valueOf(player.getBlocks())), 45, y);
				centerGridPane.add(new Label(String.valueOf(player.getSteals())), 50, y);
				centerGridPane.add(new Label(String.valueOf(player.getFouls())), 55, y);
				centerGridPane.add(new Label(String.valueOf(player.getRebounds())), 60, y);
				
				y+=1;
			}
		}
	}
}
