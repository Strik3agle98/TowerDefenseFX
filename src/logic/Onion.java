package logic;

import javafx.scene.image.Image;

public class Onion extends Target {
	public Onion() {
		super("Onion");
		super.setImage(new Image("Enemy_2_Attacking.gif"),new Image("Enemy_2_Walk.gif"));
		super.setHealth(100);
		super.setdx(1.0);
		//super.setAttackSpeed(20);
		super.setDamage(20);
	}
}
