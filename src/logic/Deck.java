package logic;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Deck extends GridPane{
	private double posX,posY,defaultX,defaultY;
	public Deck() {
		for(int i = 0; i < 7; i++) {
			Canvas c = new Canvas(100,100);
			c.setCursor(Cursor.HAND);
			c.setOnMousePressed((t) -> {
				t.setDragDetect(true);
				System.out.println(t.getSceneX() + " " + t.getSceneY());
				defaultX = c.getTranslateX();
				defaultY = c.getTranslateY();
				posX = t.getSceneX() - c.getTranslateX();
				posY = t.getSceneY() - c.getTranslateY();
				c.getGraphicsContext2D().setFill(Color.YELLOWGREEN);
				c.getGraphicsContext2D().fillRect(0,0,c.getWidth(),c.getHeight());
				t.consume();
			});
			c.setOnMouseDragged((t) -> {
				c.setTranslateX(t.getSceneX() - posX);
				c.setTranslateY(t.getSceneY() - posY);
				t.consume();
			});
			c.setOnMouseReleased((t) ->{
				c.setTranslateX(defaultX);
				c.setTranslateY(defaultY);
				c.getGraphicsContext2D().setFill(Color.YELLOW);
				c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(), c.getHeight());
				t.consume();
			});
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setStroke(Color.BLACK);
			gc.setFill(Color.YELLOW);
			gc.fillRect(0, 0, c.getWidth(), c.getHeight());
			gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
			add(c,i,0);
			setStyle("-fx-grid-lines-visible: true");
		}
	}
}
