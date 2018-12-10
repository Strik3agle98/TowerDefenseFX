package logic;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.*;
import java.util.Random;

public class Field extends GridPane{
	private static Canvas battlefield = new Canvas(1200,650);
	private static ArrayList<Target> targets = new ArrayList<Target>();
	private static ArrayList<Tower> towers = new ArrayList<Tower>();
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private static int[] enemyCount = {0, 0, 0, 0, 0};
	private static Tower[][] table = {
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null}
	};
	public Field() {
		battlefield = new Canvas(1200,650);
		System.out.println(battlefield.hashCode());
		battlefield.getGraphicsContext2D().drawImage(new Image("Field.jpg"), 0, 0);
		//battlefield.setStyle("-fx-background-image: Field.jpg");
		setPadding(new Insets(10,10,10,10));
		getChildren().addAll(battlefield);
		System.out.println(battlefield.hashCode());
	}
	public static boolean addTower(Tower tower,int row,int col) {
		if(table[row][col] == null) {
			setTable(tower,row,col);
			towers.add(tower);
			tower.setRow(row);
			tower.setCol(col);
			tower.setY(130 * row + 20);
			tower.setX(130 * col + 30);
			System.out.println("Generated tower at row " + row + " ,col " + col);
			
			return true;
		}
		return false;
	}
	public static void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	public void addTarget(Target target) {
		Random rand = new Random();
		int row = rand.nextInt() % 5;
		if(row < 0) row += 5;
		target.setX(1100);
		target.setY(130 * (row) + 20);
		target.setRow(row);
		enemyCount[row]++;
		System.out.println("Generated target at row " + row);
		targets.add(target);
	}
	public void addTargets(ArrayList<Target> targets) {
		for(Target t : targets) {
			addTarget(t);
		}
	}
	public static void display(Object o) {
		//System.out.println("class entered");
		if(o instanceof Tower) {
			//System.out.println("Displaying tower at " + ((Tower)o).getX() + " " + ((Tower)o).getY());
			battlefield.getGraphicsContext2D().drawImage(((Tower)o).getImage(), ((Tower)o).getX(), ((Tower)o).getY());
		}
		else if(o instanceof Target) {
			System.out.println("Displaying target at " + ((Target)o).getX() + " " + ((Target)o).getY() + "row " + ((Target)o).getRow());
			battlefield.getGraphicsContext2D().drawImage(((Target)o).getImage(), ((Target)o).getX(), ((Target)o).getY());
		}
		else if(o instanceof Bullet) {
			battlefield.getGraphicsContext2D().drawImage(((Bullet)o).getImage(), ((Bullet)o).getX(), ((Bullet)o).getY());
		}
	}
	public Tower[][] getTable(){
		return Field.table;
	}
	public void setTable(Tower[][] table) {
		Field.table = table;
	}
	public static Tower getTable(int row,int col) {
		return table[row][col];
	}
	public static void setTable(Tower tower,int row,int col) {
		table[row][col] = tower;
	}
	public int[] getEnemyCount() {
		return enemyCount;
	}
	public static int getEnemyCount(int index) {
		if(index < 0 || index > 4) return -1;
		return enemyCount[index];
	}
	public void setEnemyCount(int[] enemyCount) {
		Field.enemyCount = enemyCount;
	}
	public Canvas getBattlefield() {
		return battlefield;
	}
	public void setBattlefield(Canvas battlefield) {
		Field.battlefield = battlefield;
	}
	public static ArrayList<Target> getTargets() {
		return targets;
	}
	public static void setTargets(ArrayList<Target> targets) {
		Field.targets = targets;
	}
	public static ArrayList<Tower> getTowers() {
		return towers;
	}
	public static void setTowers(ArrayList<Tower> towers) {
		Field.towers = towers;
	}
	public static ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public static void setBullets(ArrayList<Bullet> bullets) {
		Field.bullets = bullets;
	}
	public static void updateCharacterStatus() {
		ArrayList<Object> t = new ArrayList<Object>();
		for(Target target : targets) {
			target.update();
			if(target.isDead()) {
				Logic.SCORE += 1000;
				Logic.MONEY += 100;
				t.add((Object)target);
				enemyCount[target.getRow()]--;
			}
			else {
				display((Object)target);
			}
		}
		for(Tower tower : towers) {
			if(tower instanceof ShootingTower)
				((ShootingTower)tower).update();
			if(tower.isDead()) {
				t.add((Object)tower);
				table[tower.getRow()][tower.getCol()] = null;
			}
			else {
				display((Object)tower);
			}
		}
		for(Bullet bullet : bullets) {
			if(bullet.getX() >= battlefield.getWidth()) {
				t.add((Object)bullet);
			}
			else {
				bullet.update();
				display((Object)bullet);
			}
		}
		targets.removeAll(t);
		towers.removeAll(t);
		bullets.removeAll(t);
	}
	public static void checkCollision() {
		ArrayList<Bullet> t = new ArrayList<Bullet>();
		for(Bullet bullet : bullets) {
			for(Target target : targets) {
				if(bullet.isCollidingWith(target)) {
					target.takeDamage(20);
					t.add(bullet);
				}
			}
		}
		bullets.removeAll(t);
		for(Tower tower : towers) {
			for(Target target : targets) {
				if(tower.isCollidingWith(target)) {
					target.stopWalk();
					target.startAttacking(tower);
				}
				else {
					if(target.getRow() == tower.getRow()) {
						target.stopAttacking();
						target.startWalk();
					}
				}
			}
		}
	}
	public static void update() {
		battlefield.getGraphicsContext2D().clearRect(0, 0, battlefield.getWidth(), battlefield.getHeight());
		checkCollision();
		updateCharacterStatus();
	}
	
}
