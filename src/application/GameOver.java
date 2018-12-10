package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import logic.User;

public class GameOver extends VBox{
	private Button proceed;
	
	public GameOver() {
		
		setAlignment(Pos.CENTER);
		setPrefSize(GUI.W,GUI.H);
		//Canvas c = new Canvas(GUI.W,GUI.H);
		setStyle("-fx-background-image: url('GameOver.jpg')");
		//c.getGraphicsContext2D().fillText("Game Over", GUI.W / 2, GUI.H / 2);
		proceed = new Button("");
		proceed.setPrefSize(200, 50);
		proceed.setStyle("-fx-background-image: url('PROCEED.png')");
		proceed.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				System.out.println("You pressed proceed.");
				GUI.getStage().setScene(GUI.getSceneOfMainMenu());
			}
		});
		proceed.setCursor(Cursor.HAND);
		getChildren().add(proceed);
	}
}
