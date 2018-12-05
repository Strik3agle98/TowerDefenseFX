package logic;

import javafx.scene.image.Image;

public class Card {
	private Tower type;
	private int cost;
	private int reloadTime;
	private Image cardImage;
	public Card(Tower type){
		this.type = type;
	}
}
