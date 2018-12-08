package logic;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

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
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
}
