package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class GUI extends Application {
	private static Data data;
	private static Stage guiStage;
	private static Scene sc_Settings;
	private static Scene sc_MainMenu;
	private static Scene sc_Scoreboard;
	private static Scene sc_Map;
	private static Scene sc_NameEntering;
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
	public static Scene getSceneOfMap() {
		return sc_Map;
	}
	public static Data getData() {
		return data;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			guiStage = primaryStage;
			MainMenu mainMenu = new MainMenu();
			Settings settings = new Settings();
			Scoreboard scoreboard = new Scoreboard();
			NameEntering nameEntering = new NameEntering();
			Map map = new Map();
			sc_MainMenu = new Scene(mainMenu,600,400);
			sc_Settings = new Scene(settings, 600,400);
			sc_Scoreboard = new Scene(scoreboard,600,400);
			sc_Map = new Scene(map,600,400,Color.DARKGREEN);
			sc_NameEntering = new Scene(nameEntering,600,400);
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
