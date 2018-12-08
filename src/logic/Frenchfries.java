package logic;

import application.Field;
import javafx.scene.image.Image;

public class Frenchfries extends Tower implements Shootable{
	private int shootingSpeed;
	private Thread shootingThread;
	private Thread reloadThread;
	public Frenchfries(int row,int col){
		super("Frenchfries", 100,20);
		super.setImage(new Image("Tower_1_Standby.gif"));
		super.setRow(row);
		super.setCol(col);
		startShooting();
	}
	@Override
	public void startShooting() {
		// TODO Auto-generated method stub
		System.out.println("Started shooting");
		shootingThread = new ShootingThread(this);
		shootingThread.start();
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
		// TODO Auto-generated method stub
		this.shootingSpeed = shootingSpeed;
	}
	public Thread getShootingThread() {
		return shootingThread;
	}
	public void setShootingThread(Thread shootingThread) {
		this.shootingThread = shootingThread;
	}
	public Thread getReloadThread() {
		return reloadThread;
	}
	public void setReloadThread(Thread reloadThread) {
		this.reloadThread = reloadThread;
	}
	public static void reload() {
		//new ReloadThread().start();
	}
}
class ReloadThread extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("ReloadThread Interrupted!");
		}
	}
}
class ShootingThread extends Thread {
	Frenchfries frenchfries;
	public ShootingThread(Frenchfries frenchfries) {
		this.frenchfries = frenchfries;
	}
	public void run() {
		while(true) {
			for(int i = 0; i < 3; i++) {
				//System.out.println("Shooting");
				FrenchFryBullet frenchFryBullet = new FrenchFryBullet();
				frenchFryBullet.setX(this.frenchfries.x + 30);
				frenchFryBullet.setY(this.frenchfries.y + 30);
				frenchFryBullet.setRow(this.frenchfries.getRow());
				Field.addBullet(frenchFryBullet);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Shooting Interrupted");
				}
			}
			
		}
	}
}
