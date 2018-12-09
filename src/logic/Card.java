package logic;

import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class Card extends Canvas{
	public Card(int i) {
		setWidth(100);
		setHeight(130);
		setCursor(Cursor.HAND);
		System.out.println("Card_" + i + ".png");
		getGraphicsContext2D().drawImage(new Image("Card_" + i + ".png"), 0, 0, 100, 130);
		
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
}
