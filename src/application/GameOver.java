package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class GameOver extends GridPane{
	public GameOver() {
		setPrefSize(GUI.W,GUI.H);
		Canvas c = new Canvas(GUI.W,GUI.H);
		c.getGraphicsContext2D().fillText("Game Over", GUI.W / 2, GUI.H / 2);
	}
	
}
