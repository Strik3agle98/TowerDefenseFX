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
		getChildren().addAll(map,deck);
		
	}
	public Deck getDeck() {
		return deck;
	}
	public Map getMap() {
		return map;
	}
}
