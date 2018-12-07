package application;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
public class GameScreen extends StackPane{
	private GameUIController gameUIController;
	private Field field;
	public GameScreen() {
		GUI.setSceneOfGameScreen(new Scene(this,GUI.W,GUI.H));
		gameUIController = new GameUIController();
		field = new Field();
		getChildren().addAll(field, gameUIController);
		
	}
	public Field getField() {
		return this.field;
	}
	public GameUIController getGameUIController() {
		return gameUIController;
	}
}
