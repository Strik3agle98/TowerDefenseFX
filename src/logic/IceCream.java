package logic;

import javafx.scene.image.Image;

public class IceCream extends Tower implements Shootable{
	private int shootingSpeed;
	public IceCream(int row,int col) {
		super("Ice-Cream",100,50);
		super.setImage(new Image("Tower2_standby.gif"));
		super.setRow(row);
		super.setCol(col);
	}

	@Override
	public void startShooting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopShooting() {
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
