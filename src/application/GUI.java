package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import logic.Logic;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class GUI extends Application {
	private static final int W = 1200, H = 800;
	private static Data data;
	private static Stage guiStage;
	private static Scene sc_Settings;
	private static Scene sc_MainMenu;
	private static Scene sc_Scoreboard;
	private static Scene sc_GameScreen;
	private static Scene sc_NameEntering;
	private static int Score = 0;
	public static Stage getStage() {
		return guiStage;
	}
	public static Scene getSceneOfMainMenu() {
		return sc_MainMenu;
	}
	public static Scene getSceneOfNameEntering() {
		return sc_NameEntering;
	}
	public static Scene getSceneOfSettings() {
		return sc_Settings;
	}
	public static Scene getSceneOfScoreboard() {
		return sc_Scoreboard;
	}
	public static Scene getSceneOfGameScreen() {
		return sc_GameScreen;
	}
	public static Data getData() {
		return data;
	}
	public static int getScore() {
		return Score;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			guiStage = primaryStage;
			MainMenu mainMenu = new MainMenu();
			Settings settings = new Settings();
			Scoreboard scoreboard = new Scoreboard();
			NameEntering nameEntering = new NameEntering();
			GameScreen gameScreen = new GameScreen();
			sc_MainMenu = new Scene(mainMenu,W,H);
			sc_Settings = new Scene(settings, W,H);
			sc_Scoreboard = new Scene(scoreboard,W,H);
			sc_GameScreen = new Scene(gameScreen,W,H,Color.DARKGREEN);
			sc_NameEntering = new Scene(nameEntering,W,H);
			SceneManager sceneManager = new SceneManager();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			data = new Data(new ArrayList<User>());
			primaryStage.setScene(sc_MainMenu);
			primaryStage.show();
			primaryStage.setTitle("TowerDefense");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
