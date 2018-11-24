package logic;
//parent class for all tower
public abstract class Tower {
	private int firepower;
	private int range;
	
	public Tower(int firepower, int range) {
		this.firepower = firepower;
		this.range = range;
	}
	
	public void fireat(Target target) {
		if(target.getHealth()>this.firepower) target.setHealth(target.getHealth()-firepower);
		else target.setHealth(0);
	}

	//getter and setter
	public int getFirepower() {
		return firepower;
	}

	public int getRange() {
		return range;
	}
}
