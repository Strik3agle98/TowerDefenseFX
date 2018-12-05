package logic;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Deck extends GridPane{
	public Deck() {
		
		for(int i = 0; i < 7; i++) {
			
			Canvas c = new Canvas(100,100);
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setStroke(Color.BLACK);
			gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
			add(c,i,0);
		}
	}
}
