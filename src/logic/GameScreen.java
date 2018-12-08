package logic;
import java.util.ArrayList;

import application.GUI;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
public class GameScreen extends StackPane{
	private GameUIController gameUIController;
	private Field field;
	private Image FIMG;
	private ImageView FIMGV;
	
	public GameScreen() {
		GUI.setSceneOfGameScreen(new Scene(this,GUI.W,GUI.H));
		gameUIController = new GameUIController();
		field = new Field();
		FIMG = new Image("Field.jpg");
		FIMGV = new ImageView(FIMG);
		
		getChildren().addAll(FIMGV, field, gameUIController);
		
	}
	public Field getField() {
		return this.field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public GameUIController getGameUIController() {
		return gameUIController;
	}
	public void setGameUIController(GameUIController gameUIController) {
		this.gameUIController = gameUIController;
	}
}
