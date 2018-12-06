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
import logic.*;

public class Field extends GridPane{
	Pane battlefield;

	private static int[][] table = {
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}
	};
	public Field() {
		battlefield = new Pane();
		battlefield.setPrefSize(1200, 650);
		battlefield.setStyle("-fx-background-color: grey");
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
	public void addTarget(int row) {
		StackPane t = new StackPane();
		t.setPrefSize(100, 100);
		Image img = new Image("Zombie_1.png");
		ImageView imgView =  new ImageView(img);
		//t.setBackground(new BackgroundImage(img, null,null,null,null));
		battlefield.getChildren().add(t);
		t.setTranslateX(1150);
		t.setTranslateY(65 * (row + 1));
	}
	public static int getTable(int x,int y) {
		return table[x][y];
	}
	public static void setTable(int x,int y,int z) {
		table[x][y] = z;
		
	}
	public Pane getBattlefield() {
		return battlefield;
	}
	public static void update() {
		
	}
}
