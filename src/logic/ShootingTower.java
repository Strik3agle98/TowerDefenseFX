package logic;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class ShootingTower extends Tower implements Shootable{
	private int countTimer;
	private int shootingSpeed;
	private Thread shootingThread;
	private boolean isShooting = false;
	public ShootingTower(String name,int row,int col){
		super(name, 100,20);
		super.setRow(row);
		super.setCol(col);
	}
	@Override
	public void startShooting() {
		if(Field.getEnemyCount(getRow()) == 0) return;
		System.out.println("Started shooting");
		if(countTimer > 10000) {
			countTimer = 0;
			while(countTimer < 10000) countTimer++;
			countTimer = 0;
		}
		if(countTimer % 1000 == 0) {
			Bullet bullet = new Bullet();
			bullet.setX(getX() + 30);
			bullet.setY(getY() + 30);
			bullet.setRow(getRow());
			if(name.equals("Frenchfries")) {
				bullet.setImage(new Image("Bullet_1.png"));
			}
			else if(name.equals("Ice-Cream")){
				bullet.setImage(new Image("Bullet_2.png"));
			}
			else if(name.equals("Hamburger")) {
				bullet.setImage(new Image("Bullet_3.png"));
			}
			Field.addBullet(bullet);
		}
		countTimer++;
//		shootingThread = new ShootingThread(this);
//	    shootingThread.start();
	}
	@Override
	public void stopShooting() {
		shootingThread.stop();
	}
	public int getShootingSpeed() {
		return this.shootingSpeed;
	}
	@Override
	public void setShootingSpeed(int shootingSpeed) {
		this.shootingSpeed = shootingSpeed;
	}
	public Thread getShootingThread() {
		return shootingThread;
	}
	public void setShootingThread(Thread shootingThread) {
		this.shootingThread = shootingThread;
	}
	public boolean isShooting() {
		return this.isShooting;
	}
	public void setIsShooting(boolean b) {
		this.isShooting = b;
	}

	public int getCountTimer() {
		return countTimer;
	}

	public void setCountTimer(int countTimer) {
		this.countTimer = countTimer;
	}
	public void update() {
		if(Field.getEnemyCount(super.getRow()) != 0 && !isShooting) {
			startShooting();
			super.setInAttackingState(true);
			isShooting = true;
		}
		else if(Field.getEnemyCount(super.getRow()) == 0 && isShooting) {
			stopShooting();
			super.setInAttackingState(false);
			isShooting = false;
		}
	}
}
