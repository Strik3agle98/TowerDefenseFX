package logic;
//parent class for all tower
public abstract class Tower {
	private int firepower;
	private int range;
	private int reload;
	private int health;
	public Tower(int firepower, int range, int reload) {
		this.firepower = firepower;
		this.range = range;
		this.reload = reload;
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
	public void update() {
		
	}
}
