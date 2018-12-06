package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.Deck;

public class Map extends GridPane{
	public Map() {
		setPadding(new Insets(10,10,10,10));
		for(int x = 0; x < 8; x++) {
			for(int i = 0; i < 5; i++) {
				Canvas c = new Canvas(130,130);
//				c.setOnMouseDragReleased((t) ->{
//					System.out.println("Snap to grid");
//					c.getGraphicsContext2D().setFill(Color.YELLOW);
//					c.getGraphicsContext2D().fillRect(0,0, c.getWidth(), c.getHeight());
//				});
//				c.setOnMouseDragOver((t) ->{
//					System.out.println("Hovered to grid!");
//					
//				});
//				c.setOnMouseDragEntered((t) -> {
//					System.out.println("Entered this grid");
//					c.getGraphicsContext2D().setFill(Color.RED);
//					c.getGraphicsContext2D().fillRect(0,0, c.getWidth(), c.getHeight());
//				});
////				c.setOnDragDropped((t) -> {
////					System.out.println("Drop Successful");
////					c.getGraphicsContext2D().setFill(Color.BROWN);
////					c.getGraphicsContext2D().fillRect(0,0, c.getWidth(), c.getHeight());
////				});
//				c.setOnMouseDragExited((t) -> {
//					System.out.println("Drag out of this node");
//					c.getGraphicsContext2D().setFill(Color.AQUA);
//					c.getGraphicsContext2D().fillRect(0,0, c.getWidth(), c.getHeight());
//				});
//				c.setOnMousePressed((t) ->{
//					System.out.println("Pressed on Node");
//					
//				});
				
				c.setOnDragOver((t)->{
					System.out.println("On drag over");
					if (t.getGestureSource() != c && t.getDragboard().hasString()) {
						/* allow for moving */
						t.acceptTransferModes(TransferMode.MOVE);
					}

					t.consume();
				});
				c.setOnDragEntered(new EventHandler<DragEvent>() {
					@Override
					public void handle(DragEvent event) {
						/* the drag-and-drop gesture entered the c */
						System.out.println("onDragEntered");
						/* show to the user that it is an actual gesture c */
						if (event.getGestureSource() != c && 
								event.getDragboard().hasString()) {
							//c.set(Color.GREEN);
							//c.getGraphicsContext2D().setFill(Color.GREEN);
							//c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(),c.getHeight());
						}

						event.consume();
					}
				});

				c.setOnDragExited(new EventHandler<DragEvent>() {
					@Override
					public void handle(DragEvent event) {
						/* mouse moved away, remove the graphical cues */
						//c.setFill(Color.BLACK);
						//c.getGraphicsContext2D().setFill(Color.AQUA);
						//c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(),c.getHeight());
						event.consume();
					}
				});

				c.setOnDragDropped(new EventHandler<DragEvent>() {
					@Override
					public void handle(DragEvent event) {
						/* data dropped */
						System.out.println("on Drag Dropped");
						/* if there is a string data on dragboard, read it and use it */
						Dragboard db = event.getDragboard();
						boolean success = false;
						if (db.hasString()) {
							System.out.println("GOT " + db.getString() + " at row : " + getRowIndex(c) + ", at column : " + getColumnIndex(c));
							Field.setTable(getRowIndex(c),getColumnIndex(c),Integer.parseInt(db.getString().substring(6, 7)));
							success = true;
							//c.getGraphicsContext2D().setFill(Color.BLACK);
							//c.getGraphicsContext2D().fillRect(0, 0, c.getWidth(),c.getHeight());
						}
						/*
						 * let the c know whether the string 
						 * was successfully transferred and used
						 */
						event.setDropCompleted(success);
						event.consume();
					}
				});

				c.setOnDragDone(new EventHandler<DragEvent>() {
					@Override
					public void handle(DragEvent event) {
						/* the drag-and-drop gesture ended */
						System.out.println("onDragDone");
						/* if the data was successfully moved, clear it */
						if (event.getTransferMode() == TransferMode.MOVE) {
						
						}

						event.consume();
					}
				});
				setStyle("-fx-grid-lines-visible: true");
				GraphicsContext gc = c.getGraphicsContext2D();
				//gc.setFill(Color.AQUA);
				//gc.fillRect(0, 0, c.getWidth(), c.getHeight());
				//gc.setStroke(Color.BLACK);
				//gc.strokeRect(0, 0, c.getWidth(), c.getHeight());
				add(c,x,i);
			}
		}
		
	}
}
