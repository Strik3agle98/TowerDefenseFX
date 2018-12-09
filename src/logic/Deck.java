package logic;

import java.util.ArrayList;

import application.GUI;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
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
	private ArrayList<Canvas> cards;
	private double posX,posY,defaultX,defaultY;
	private Canvas score;
	public Deck() {
		cards = new ArrayList<Canvas>();
		score = new Canvas(100,100);
		drawCurrentScoreString(score.getGraphicsContext2D());
		add(score,0,0);
		for(int i = 1; i <= 3; i++) {
			Canvas c = new Canvas(100,130);
			cards.add(c);
			c.setCursor(Cursor.HAND);
			System.out.println("Card_" + i + ".png");
			c.getGraphicsContext2D().drawImage(new Image("Card_" + i + ".png"), 0, 0, 100, 130);
			
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
			add(c,i,0);
		}
		setStyle("-fx-grid-lines-visible: true");
		setPadding(new Insets(10,10,10,10));
		
	}
	public void drawCurrentScoreString(GraphicsContext gc){
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, this.score.getWidth(), this.score.getHeight());
		gc.fillText("" + GUI.getScore(), this.score.getWidth() / 2, this.score.getWidth() / 2);
	}
	public void update() {
		for(Node node : getChildren()) {
			
		}
	}
}
