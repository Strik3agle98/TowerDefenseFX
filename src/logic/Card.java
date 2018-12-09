package logic;

import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class Card extends Canvas{
	private double progress = 0.0;
	private boolean isReloading = false;
	
	public Card(int i) {
		setWidth(100);
		setHeight(130);
		setCursor(Cursor.HAND);
		System.out.println("Card_" + i + ".png");
		getGraphicsContext2D().drawImage(new Image("Card_" + i + ".png"), 0, 0, getWidth(), getHeight());
		
		setOnDragDetected((t)->{
			System.out.println("Drag Detected");
			Dragboard db = startDragAndDrop(TransferMode.MOVE);
			ClipboardContent content = new ClipboardContent();
			content.putImage(new Image("Tower_" + i + ".png", 100,100,false,false));
			content.putString("Tower_" + i);
			db.setContent(content);
			t.consume();
		});
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}

	public boolean isReloading() {
		return isReloading;
	}

	public void setReloading(boolean isReloading) {
		this.isReloading = isReloading;
	}
	public void updateProgress(double d) {
		for(int i = 0; i <= 100; i++) {
			
		}
	}
}
