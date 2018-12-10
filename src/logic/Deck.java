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
	private static ArrayList<Card> cards;
	private double posX,posY,defaultX,defaultY;
	private Canvas score;
	public Deck() {
		cards = new ArrayList<Card>();
		score = new Canvas(100,100);
		drawCurrentScoreString(score.getGraphicsContext2D());
		add(score,0,0);
		for(int i = 1; i <= 3; i++) {
			Card c = new Card(i);
			cards.add(c);
			add(c,i,0);
		}
		//setStyle("-fx-grid-lines-visible: true");
		setPadding(new Insets(10,10,10,10));
		
	}
	public void drawCurrentScoreString(GraphicsContext gc){
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, this.score.getWidth(), this.score.getHeight());
		gc.fillText("" + GUI.getScore(), this.score.getWidth() / 2, this.score.getWidth() / 2);
	}
	public static Card getCard(int i) {
		return cards.get(i - 1);
	}
	public static void update() {
		for(Card card : cards) {
			if(card.isReloading()) {
				System.out.println("Updating card");
				card.updateProgress(1);
				System.out.println("Updated card");
			}
		}
		
	}
}
