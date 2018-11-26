package application;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
public class Map extends StackPane{
	private GridPane map;
	private Rectangle r;
	public Map() {
		map = new GridPane();
		r = new Rectangle();
		r.setX(0);
		r.setY(0);
		r.setWidth(50);
		r.setHeight(50);
		map.getChildren().addAll(r);
		getChildren().addAll(map);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case ESCAPE : GUI.getStage().setScene(GUI.getSceneOfSettings());
						break;
					default:
						break;
				}
			}
		});
	}
}
