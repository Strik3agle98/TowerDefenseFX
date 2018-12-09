package logic;

import javafx.scene.image.Image;

public class IceCream extends ShootingTower{
	public IceCream(int row,int col) {
		super("Ice-Cream",100,50);
		super.setImage(new Image("Tower2_Attacking.gif"),new Image("Tower2_Standby.gif"));
		super.setRow(row);
		super.setCol(col);
	}
	
}