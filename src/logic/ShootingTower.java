package logic;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class ShootingTower extends Tower implements Shootable{
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
		System.out.println("Started shooting");
//		final Tower tower = this;
//		Task<Void> task = new Task<Void>() {
//	        @Override protected Void call() throws Exception {
//	        	while(true) {
//	        		if (isCancelled()) {
//	                    return null;
//	                }
//	    			for(int i = 0; i < 3; i++) {
//	    				System.out.println("Shooting");
//	    				Bullet bullet = new Bullet();
//	    				bullet.setX(tower.x + 30);
//	    				bullet.setY(tower.y + 30);
//	    				bullet.setRow(tower.getRow());
//	    				if(tower.name.equals("Frenchfries")) {
//	    					bullet.setImage(new Image("Bullet_1.png"));
//	    				}
//	    				else if(tower.name.equals("Ice-Cream")){
//	    					bullet.setImage(new Image("Bullet_1.png"));
//	    				}
//	    				else if(tower.name.equals("Hamburger")) {
//	    					bullet.setImage(new Image("Bullet_1.png"));
//	    				}
//	    				Field.addBullet(bullet);
//	    				try {
//	    					Thread.sleep(1000);
//	    				} catch (Exception e) {
//	    					System.out.println("ShootingThread Interrupted");
//	    				}
//	    			}
//	    			try {
//	    				Thread.sleep(2000);
//	    			} catch(Exception e) {
//	    				System.out.println("Reloading Interrupted");
//	    			}
//	    		}
//	        }
//	    };
//	    shootingThread = new Thread(task);
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
