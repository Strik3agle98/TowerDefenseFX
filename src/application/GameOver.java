package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class GameOver extends GridPane{
	public GameOver() {
		setPrefSize(GUI.W,GUI.H);
		Canvas c = new Canvas(GUI.W,GUI.H);
		c.setStyle("-fx-background-image: url('icecream4.gif')");
		c.getGraphicsContext2D().fillText("Game Over", GUI.W / 2, GUI.H / 2);
		getChildren().add(c);
	}
	
}
