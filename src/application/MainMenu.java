package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class MainMenu extends VBox{
	Button play, settings, scoreboard;
	Image FT;
	ImageView FTView;
	
	public MainMenu() {
		FT = new Image("Tower_1_Standby.gif");
		FTView = new ImageView(FT);
		play = new Button("Play");
		settings = new Button("Settings");
		scoreboard = new Button("Scoreboard");
		play.setPrefSize(400, 50);
		settings.setPrefSize(400,50);
		scoreboard.setPrefSize(400,50);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(20,20,20,20));

		setSpacing(20);
		play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Play button pressed");
				GUI.getStage().setScene(GUI.getSceneOfNameEntering());
			}
		});
		play.setCursor(Cursor.HAND);
		settings.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				System.out.println("Settings button pressed");
				GUI.getStage().setScene(GUI.getSceneOfSettings());
			}
		});
		settings.setCursor(Cursor.HAND);
		scoreboard.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				System.out.println("Scoreboard button pressed");
				GUI.getStage().setScene(GUI.getSceneOfScoreboard());
			}
		});
		scoreboard.setCursor(Cursor.HAND);
		//getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		setStyle("-fx-background-image: url('background_0.jpg'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch; "
				+ "-fx-background-size: 1400 1000;");
		getChildren().addAll(play,settings,scoreboard, FTView);
	}
	
}
