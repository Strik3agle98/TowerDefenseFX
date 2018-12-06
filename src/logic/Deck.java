package logic;

import application.GUI;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Deck extends GridPane{
	private double posX,posY,defaultX,defaultY;
	private Canvas score;
	public Deck() {
		score = new Canvas(100,100);
		drawCurrentScoreString(score.getGraphicsContext2D());
		add(score,0,0);
		for(int i = 1; i <= 7; i++) {
			Canvas c = new Canvas(100,100);
			c.setCursor(Cursor.HAND);
//			c.setOnMousePressed((t) -> {
//				t.setDragDetect(true);
//				System.out.println(t.getSceneX() + " " + t.getSceneY());
//				defaultX = c.getTranslateX();
//				defaultY = c.getTranslateY();
//				posX = t.getSceneX() - c.getTranslateX();
//				posY = t.getSceneY() - c.getTranslateY();
//				c.getGraphicsContext2D().setFill(Color.YELLOWGREEN);
//				c.getGraphicsContext2D().fillRect(0,0,c.getWidth(),c.getHeight());
//				t.consume();
//			});
//			c.setOnMouseDragged((t) -> {
//				c.setTranslateX(t.getSceneX() - posX);
//				c.setTranslateY(t.getSceneY() - posY);
//				t.consume();
//			});
//			c.setOnMouseReleased((t) ->{
//				c.setTranslateX(defaultX);
//				c.setTranslateY(defaultY);
//				c.getGraphicsContext2D().setFill(Color.YELLOW);
//				c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(), c.getHeight());
//				t.consume();
//			});
			System.out.println("Card_" + i + ".png");
			c.getGraphicsContext2D().drawImage(new Image("Card_" + i + ".png"), 0, 0, 100, 100);
			
			c.setOnDragDetected((t)->{
				System.out.println("Drag Detected");
				Dragboard db = c.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(new Image("Tower_" + getColumnIndex(c) + ".png", 100,100,false,false));
				content.putString("Tower_" + getColumnIndex(c));
				db.setContent(content);
				t.consume();
			});
			GraphicsContext gc = c.getGraphicsContext2D();
			gc.setStroke(Color.BLACK);
			//gc.setFill(Color.YELLOW);
			
			//gc.fillRect(0, 0, c.getWidth(), c.getHeight());
			//gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
		
			add(c,i,0);
			setStyle("-fx-grid-lines-visible: true");
		}
		setPadding(new Insets(10,10,10,10));
		
	}
	public void drawCurrentScoreString(GraphicsContext gc){
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, this.score.getWidth(), this.score.getHeight());
		gc.fillText("" + GUI.getScore(), this.score.getWidth() / 2, this.score.getWidth() / 2);
	}
}
