package application;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map extends GridPane{
	private GridPane Table;
	public Map() {
		setPadding(new Insets(100,100,100,100));
		for(int x = 0; x < 5; x++) {
			for(int i = 0; i < 8; i++) {
				Canvas c = new Canvas(100,100);
				GraphicsContext gc = c.getGraphicsContext2D();
				gc.setFill(Color.AQUA);
				gc.fillRect(0, 0, c.getWidth(), c.getHeight());
				gc.setStroke(Color.BLACK);
				gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
				add(c,i,x);
			}
		}
		Table = new GridPane();
		
	}
}
