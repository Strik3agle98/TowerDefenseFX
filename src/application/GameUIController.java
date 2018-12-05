package application;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import logic.Deck;

public class GameUIController extends VBox{
	private Map map;
	private Deck deck;
	public GameUIController() {
		
		deck = new Deck();
		map = new Map();
		setPadding(new Insets(10,10,10,10));
		getChildren().addAll(deck,map);
		deck.toFront();
	}
}
