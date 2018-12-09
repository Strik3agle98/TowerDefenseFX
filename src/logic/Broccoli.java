package logic;

import javafx.scene.image.Image;

public class Broccoli extends Target{
	public Broccoli() {
		super("Broccoli");
		super.setHealth(150);
		super.setdx(0.7);
		super.setDamage(40);
		super.setAttackSpeed(40);
		super.setImage(new Image("Enemy_1_Attacking.gif"),new Image("Enemy_1_Walk.gif"));
	}
}
