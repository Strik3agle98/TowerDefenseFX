package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Scoreboard extends VBox{
	private Button back;
	public Scoreboard() {
		
		back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed back.");
				GUI.getStage().setScene(GUI.getSceneOfMainMenu());
			}
		});
		setStyle("-fx-background-image: url('BGL.jpg'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch; "
				+ "-fx-background-size: 1200 800;");
		getChildren().addAll(back);
	}
}
