package application;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.Deck;

public class Map extends GridPane{
	public Map() {
		setPadding(new Insets(10,10,10,10));
		for(int x = 0; x < 8; x++) {
			for(int i = 0; i < 6; i++) {
				Canvas c = new Canvas(130,130);
				GraphicsContext gc = c.getGraphicsContext2D();
				gc.setFill(Color.AQUA);
				gc.fillRect(0, 0, c.getWidth(), c.getHeight());
				gc.setStroke(Color.BLACK);
				gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
				add(c,x,i);
			}
		}
		
	}
}
