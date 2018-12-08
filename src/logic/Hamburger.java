package logic;

import javafx.scene.image.Image;

public class Hamburger extends Tower{
	public Hamburger(int row,int col) {
		super("Hamburger",200,100);
		super.setImage(new Image("Tower3_standby.gif"));
		super.setRow(row);
		super.setCol(col);
	}
}
