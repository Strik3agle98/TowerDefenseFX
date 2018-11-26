package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class MainMenu extends VBox{
	Button play, settings, scoreboard;
	
	public MainMenu() {
		play = new Button("Play");
		settings = new Button("Settings");
		scoreboard = new Button("Scoreboard");
		play.setPrefWidth(100);
		settings.setPrefWidth(100);
		scoreboard.setPrefWidth(100);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(20,20,20,20));

		setSpacing(20);
		play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Play button pressed");
				GUI.getStage().setScene(GUI.getSceneOfNameEntering());
			}
		});
		settings.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				System.out.println("Settings button pressed");
				GUI.getStage().setScene(GUI.getSceneOfSettings());
			}
		});
		scoreboard.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				System.out.println("Scoreboard button pressed");
				GUI.getStage().setScene(GUI.getSceneOfScoreboard());
			}
		});
		
		getChildren().addAll(play,settings,scoreboard);
	}
	
}
