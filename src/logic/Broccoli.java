package logic;

import javafx.scene.image.Image;

public class Broccoli extends Target{
	public Broccoli() {
		super("Broccoli");
		super.setImage(new Image("Enemy_1_Eat.gif"),new Image("Enemy_1_Walk.gif"));
	}
}
