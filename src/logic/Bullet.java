package logic;

import javafx.scene.image.Image;

public class Bullet {
	private double x,y;
	private int row;
	private Image image;
	public Bullet() {
		
	}
	public boolean isCollidingWith(Target target) {
		if(this.row != target.getRow()) return false;
		if((this.x - target.getX()) * (this.x - target.getX()) < 1){
			return true;
		}
		return false;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void update() {
		setX(getX() + 0.001);
	}
}
