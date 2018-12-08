package logic;

import javafx.scene.image.Image;

public class Frenchfries extends Tower implements Shootable{
	public Frenchfries(){
		super("Frenchfries", 100,20,5);
		super.setImage(new Image("Tower_1_Standby.gif"));
	}

	@Override
	public int getReloadSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getShootingSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setShootingSpeed(int shootingSpeed) {
		// TODO Auto-generated method stub
		
	}
}
