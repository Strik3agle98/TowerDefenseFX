package logic;

import javafx.scene.image.Image;
public class ShootingThread extends Thread {
	Tower tower;
	public ShootingThread(Tower tower) {
		this.tower = tower;
	}
	public void run() {
		while(true) {
			for(int i = 0; i < 3; i++) {
				System.out.println("Shooting");
				Bullet bullet = new Bullet();
				bullet.setX(this.tower.x + 30);
				bullet.setY(this.tower.y + 30);
				bullet.setRow(this.tower.getRow());
				if(tower.name.equals("Frenchfries")) {
					bullet.setImage(new Image("Bullet_1.png"));
				}
				else if(tower.name.equals("Ice-Cream")){
					bullet.setImage(new Image("Bullet_1.png"));
				}
				else if(tower.name.equals("Hamburger")) {
					bullet.setImage(new Image("Bullet_1.png"));
				}
				Field.addBullet(bullet);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("ShootingThread Interrupted");
				}
			}
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				System.out.println("Reloading Interrupted");
			}
		}
	}
}
