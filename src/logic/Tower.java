package logic;

import javafx.scene.image.Image;

//parent class for all tower
public abstract class Tower {
	String name;
	private int firepower;
	private int range;
	private int reload;
	private int health;
	private Image image;
	public Tower(String name,int firepower, int range, int reload) {
		this.name = name;
		this.firepower = firepower;
		this.range = range;
		this.reload = reload;
	}
	public Tower(String name) {
		this.name = name;
	}
	public void fireAt(Target target) {
		if(target.getHealth() > this.firepower) target.setHealth(target.getHealth() - firepower);
		else {
			target.setHealth(0);
		}
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
	
	public int getRange() {
		return range;
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
