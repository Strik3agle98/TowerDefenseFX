package logic;

import javafx.scene.image.Image;

//parent class for all target
public class Target {
	private String name;
	private int health;
	private int speed;
	private Image image;
	public Target(String name,int health, int speed) {
		this.health = health;
		this.speed = speed;
	}
	public Target(String name) {
		this.name = name;
	}
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int amount) {
		if(amount < 0) this.health = 0;
		else this.health = amount;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(Image img) {
		image = img;
	}
	public void update() {
		
	}
}
