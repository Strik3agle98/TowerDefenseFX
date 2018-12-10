package logic;

import application.GUI;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ShootingTower extends Tower implements Shootable{
	private int countTimer = 0;
	private AudioClip Fire;
	private boolean isShooting = false;
	public ShootingTower(String name,int row,int col){
		super(name, 100,20);
		super.setRow(row);
		super.setCol(col);
		Fire = new AudioClip(ClassLoader.getSystemResource("Meow.wav").toString());
	}
	@Override
	public void startShooting() {
		System.out.println("Started shooting");
		if(countTimer > 200) {
			countTimer = 0;
			while(countTimer < 200) countTimer++;
			countTimer = 0;
		}
		if(countTimer % 100 == 0) {
			Bullet bullet = new Bullet();
			Fire.play(GUI.getVolume());
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
		System.out.println("Enemycount: " + Field.getEnemyCount(super.getRow()) + ", isShooting: " + isShooting);
		if(Field.getEnemyCount(super.getRow()) != 0) {
			startShooting();
			super.setInAttackingState(true);
			isShooting = true;
		}
		else {
			
			super.setInAttackingState(false);
			countTimer = 0;
			isShooting = false;
		}
	}
}
