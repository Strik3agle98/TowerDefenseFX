package logic;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class Frenchfries extends ShootingTower{
	
	public Frenchfries(int row,int col){
		super("Frenchfries", 100,20);
		super.setImage(new Image("Tower_1_Attacking.gif"),new Image("Tower_1_Standby.gif"));
		super.setRow(row);
		super.setCol(col);
	}
}
