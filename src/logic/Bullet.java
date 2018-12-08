package logic;

import javafx.scene.image.Image;

public class Bullet {
	private double x,y;
	private double dx = 5;
	private int row;
	private Image image;
	public Bullet() {
		x = y = row = 0;
		image = null;
	}
	public Bullet(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public Bullet(int row,double x,double y) {
		this.row = row;
		this.x = x;
		this.y = y;
	}
	public Bullet(int row,double x,double y,Image image) {
		this.row = row;
		this.x = x;
		this.y = y;
		this.image = image;
	}
	public boolean isCollidingWith(Target target) {
		if(this.row != target.getRow()) return false;
		if((this.x - target.getX()) * (this.x - target.getX()) < 10){
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
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void update() {
		setX(getX() + dx);
	}
}
