package application;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Field extends GridPane{
	Canvas battlefield;
	private static int[][] table = {
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}
	};
	public Field() {
		battlefield = new Canvas(1100,130*5);
		GraphicsContext gc = battlefield.getGraphicsContext2D();
		//battlefield.getGraphicsContext2D().drawImage(new Image("lawn2.jpg"), 20, 20, 1000,130*5);
		gc.setFill(Color.GRAY);
		gc.fillRect(0, 0, battlefield.getWidth(), battlefield.getHeight());
		setPadding(new Insets(10,10,10,10));
		
		
		getChildren().addAll(battlefield);
		
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
	public void update() {
		
	}
}
