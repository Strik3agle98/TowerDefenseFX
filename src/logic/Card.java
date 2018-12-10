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
	private int cardID;
	public Card(int i) {
		setCardID(i);
		setWidth(100);
		setHeight(130);
		setCursor(Cursor.HAND);
		System.out.println("Card_" + i + ".png");
		getGraphicsContext2D().drawImage(new Image("Card_" + i + ".png"), 0, 0, getWidth(), getHeight());
		
		//setStyle("-fx-background-image: url('Card_" + i + ".png)");
		setOnDragDetected((t)->{
			System.out.println("Drag Detected");
			if(!isReloading()) {
				Dragboard db = startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(new Image("Tower_" + i + ".png", 100,100,false,false));
				content.putString("Tower_" + i);
				db.setContent(content);
				t.consume();
			}
			else {
				System.out.println("Drag denied because reloading card.");
			}
		});
	}
	public void setFillRect(double d) {
		//getGraphicsContext2D().setFill(new Color(50, 50, 50, 0.4));
		//getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
		getGraphicsContext2D().fillRect(0, 0, getWidth(), getHeight() * d);
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
	public int getCardID() {
		return cardID;
	}
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	public void updateProgress(double d) {
		System.out.println("Update card Progress: " + progress);
		setProgress(getProgress() + d);
		setFillRect(getProgress() / 500.0);
		if(getProgress() >= 500) {
			getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
			getGraphicsContext2D().drawImage(new Image("Card_" + cardID + ".png"), 0, 0, getWidth(), getHeight());
			setProgress(0);
			setReloading(false);
		}
	} 
}
