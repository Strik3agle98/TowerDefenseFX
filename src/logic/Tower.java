package logic;

import application.Field;
import javafx.scene.image.Image;

//parent class for all tower
public abstract class Tower {
	String name = "Tower";
	private int firepower;
	private int reload;
	private int health;
	private int row, col;
	private Image image;
	double x = 0,y = 0;
	public Tower(String name,int health, int firepower, int reload) {
		this.name = name;
		this.health = health;
		this.firepower = firepower;
		this.reload = reload;
	}
	public Tower() {
	}
	public Tower(String name) {
		this.name = name;
	}
	public Tower(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public Tower(String name,double x,double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void fire(Tower tower) {
		Bullet bullet = new Bullet();
		Field.addBullet(bullet);
	}
	//getter and setter
	public int getFirepower() {
		return firepower; 
	}
	public void setFirepower(int power) {
		this.firepower = power;
	}
	public int getReload() {
		return this.reload;
	}
	public void setReload(int reload) {
		this.reload = reload;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(Image img) {
		image = img;
	}
	public double getX() {
		return this.x;
	}
	public void setX(double x) {
		if(x < 0) this.x = 0;
		else this.x = x;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		if(y < 0) this.y = 0;
		else this.y = y;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public boolean isDead() {
		return this.health <= 0;
	}
	public void update() {
		if(!isDead()) {
			
		}
		else {
			
		}
	}
}
