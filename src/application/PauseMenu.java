package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PauseMenu extends VBox{
	private Button resume,quit,settings,scoreboard;
	public PauseMenu() {
		resume = new Button("Resume");
		quit = new Button("Quit");
		settings = new Button("Settings");
		scoreboard = new Button("Scoreboard");
		resume.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed resume.");
				GUI.getStage().setScene(GUI.getSceneOfGameScreen());
				
			}
		});
		settings.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed settings.");
				GUI.getStage().setScene(GUI.getSceneOfSettings());
			}
		});
		scoreboard.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed scoreboard.");
				GUI.getStage().setScene(GUI.getSceneOfScoreboard());
			}
		});
		quit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
		 		System.out.println("You pressed quit.");
				GUI.getStage().setScene(GUI.getSceneOfMainMenu());
			}
		});
		getChildren().addAll(resume,scoreboard,settings,quit);
	}
}
