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
	private static Canvas score;
	public Deck() {
		cards = new ArrayList<Card>();
		score = new Canvas(100,100);
		drawCurrentScoreString();
		add(score,0,0);
		for(int i = 1; i <= 3; i++) {
			Card c = new Card(i);
			cards.add(c);
			add(c,i,0);
		}
		//setStyle("-fx-grid-lines-visible: true");
		setPadding(new Insets(10,10,10,10));
		
	}
	public static void drawCurrentScoreString(){
		Deck.score.getGraphicsContext2D().setFill(Color.BLACK);
		Deck.score.getGraphicsContext2D().setFont(new Font(30));
		Deck.score.getGraphicsContext2D().clearRect(0, 0, Deck.score.getWidth(), Deck.score.getHeight());
		Deck.score.getGraphicsContext2D().fillText("" + Logic.MONEY, Deck.score.getWidth() / 2 - 35, Deck.score.getWidth() / 2 + 45);
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
			card.checkMoneyStatus();
			drawCurrentScoreString();
		}
	}
}
