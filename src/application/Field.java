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
	private Canvas battlefield;
	private static ArrayList<Target> targets = new ArrayList<Target>();
	private static ArrayList<Tower> towers = new ArrayList<Tower>();
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private static int[][] table = {
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}
	};
	public Field() {
		battlefield = new Canvas(1200,650);
		
		setPadding(new Insets(10,10,10,10));
		
		getChildren().addAll(battlefield);
		
	}
	public boolean addTower(int row,int col) {
		if(table[row][col] == 0) {
			setTable(row,col,1);
			
			return true;
		}
		return false;
	}
	public void addTarget(Target target) {
		Random rand = new Random();
		int row = rand.nextInt() % 5;
		target.setX(1100);
		target.setY(65 * (row + 1));
	}
	public void addTargets(ArrayList<Target> targets) {
		for(Target t : targets) {
			addTarget(t);
		}
	}
	public static int getTable(int x,int y) {
		return table[x][y];
	}
	public static void setTable(int x,int y,int z) {
		table[x][y] = z;
		
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
	public static void update() {
		for(Target target : targets) {
			target.update();
			if(target.isDead()) {
				targets.remove(target);
			}
		}
		for(Tower tower : towers) {
			tower.update();
			if(tower.isDead()) {
				towers.remove(tower);
			}
		}
	}
}
