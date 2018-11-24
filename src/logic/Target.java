package logic;
//parent class for all target
public class Target {
	private int health;
	private int speed;
	
	public Target(int health, int speed) {
		this.health = health;
		this.speed = speed;
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
}
