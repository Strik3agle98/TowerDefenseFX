package logic;

import javafx.scene.image.Image;

//parent class for all target
public class Target {
	private String name = "Target";
	private int health = 100;
	private Image image;
	private int row;
	double x = 0, y = 0;
	double dx = 1;
	
	public Target() {
	
	}
	public Target(String name) {
		this.setName(name);
	}
	public Target(String name,int health) {
		this.setName(name);
		this.health = health;
	}
	public void takeDamage(int val) {
		health -= val;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int amount) {
		if(amount < 0) this.health = 0;
		else this.health = amount;
	}
	
	public double getdx() {
		return dx;
	}
	public void setdx(double dx) {
		this.dx = dx;
	}
	public boolean isDead() {
		return this.health <= 0;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(Image img) {
		image = img;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		if(x < 0) this.x = 0;
		else this.x = x;
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
		setX(getX() - dx);
		//System.out.println("target x : " + getX() + " , y : " + getY());
	}
}
