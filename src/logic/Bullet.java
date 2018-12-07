package logic;

import javafx.scene.image.Image;

public class Bullet {
	private double x,y;
	private Image image;
	public Bullet() {
		
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
