package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class SceneManager {
	public SceneManager() {
		Scene sc_Map = GUI.getSceneOfMap();
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
