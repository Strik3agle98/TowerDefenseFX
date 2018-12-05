package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class SceneManager {
	public SceneManager() {
		Scene sc_Map = GUI.getSceneOfMap();
		Scene sc_MainMenu = GUI.getSceneOfMainMenu();
		sc_Map.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case ESCAPE : 
						GUI.getStage().setScene(GUI.getSceneOfSettings());
					default:
						break;
				}
			}
		});
	}
}
