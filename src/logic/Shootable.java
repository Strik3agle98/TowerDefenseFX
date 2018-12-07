package logic;

public interface Shootable {
	public int getReloadSpeed();
	public void shoot();
	public int getShootingSpeed();
	public void setShootingSpeed(int shootingSpeed);
}