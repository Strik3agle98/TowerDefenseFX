package logic;

public abstract class Tower {
	int firepower;
	int range;
	
	public Tower(int firepower, int range) {
		this.firepower = firepower;
		this.range = range;
	}
	
	void fireat(Target target) {
		target.health -= this.firepower;
	}
}
