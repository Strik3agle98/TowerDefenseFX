package application;

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
	private static Canvas battlefield;
	private static ArrayList<Target> targets = new ArrayList<Target>();
	private static ArrayList<Tower> towers = new ArrayList<Tower>();
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private static Tower[][] table = {
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null}
	};
	public Field() {
		battlefield = new Canvas(1200,650);
		setPadding(new Insets(10,10,10,10));
		getChildren().addAll(battlefield);
	}
	public static boolean addTower(Tower tower,int row,int col) {
		if(table[row][col] == null) {
			setTable(tower,row,col);
			towers.add(tower);
			return true;
		}
		return false;
	}
	public static void addBullet(Bullet bullet) {
		// TODO Auto-generated method stub

	}
	public void addTarget(Target target) {
		Random rand = new Random();
		int row = rand.nextInt() % 5;
		target.setX(1100);
		target.setY(65 * (row + 1));
		targets.add(target);
	}
	public void addTargets(ArrayList<Target> targets) {
		for(Target t : targets) {
			addTarget(t);
		}
	}
	public static void display(Object o) {
		if(o instanceof Tower) {
			battlefield.getGraphicsContext2D().drawImage(((Tower)o).getImage(), ((Tower)o).getX(), ((Tower)o).getY());
		}
		else if(o instanceof Target) {
			battlefield.getGraphicsContext2D().drawImage(((Target)o).getImage(), ((Target)o).getX(), ((Target)o).getY());
		}
	}
	public static Tower getTable(int x,int y) {
		return table[x][y];
	}
	public static void setTable(Tower tower,int x,int y) {
		table[x][y] = tower;
	}
	public Canvas getBattlefield() {
		return battlefield;
	}
	public void setBattlefield(Canvas battlefield) {
		this.battlefield = battlefield;
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
	public static void update() {
		for(Target target : targets) {
			target.update();
			if(target.isDead()) {
				targets.remove(target);
			}
			else {
				display((Object)target);
			}
		}
		for(Tower tower : towers) {
			tower.update();
			if(tower.isDead()) {
				towers.remove(tower);
			}
			else {
				display(tower);
			}
		}
//		for(Bullet bullet : bullets) {
//			for(Target target : targets) {
//				//TODO: check collision
//			}
//		}
	}
	
}
