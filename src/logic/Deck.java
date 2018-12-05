package logic;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Deck extends GridPane{
	private double posX,posY;
	public Deck() {
		for(int i = 0; i < 7; i++) {
			Canvas c = new Canvas(100,100);
			c.setCursor(Cursor.HAND);
			c.setOnMousePressed((t) -> {
				t.setDragDetect(true);
				System.out.println(t.getSceneX() + " " + t.getSceneY());
				posX = t.getSceneX() - c.getTranslateX();
				posY = t.getSceneY() - c.getTranslateY();
			});
			c.setOnMouseDragged((t) -> {
				c.setTranslateX(t.getSceneX() - posX);
				c.setTranslateY(t.getSceneY() - posY);
			});
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setStroke(Color.BLACK);
			gc.setFill(Color.YELLOW);
			gc.fillRect(0, 0, c.getWidth(), c.getHeight());
			gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
			add(c,i,0);
			setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
		}
	}
}
