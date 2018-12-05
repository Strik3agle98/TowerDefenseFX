package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class SceneManager {
	public SceneManager() {
		FieldController();
		
	}
	public void FieldController() {
		Scene sc_GameScreen = GUI.getSceneOfGameScreen();
		sc_GameScreen.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
