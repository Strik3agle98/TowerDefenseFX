package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class MainMenu extends VBox{
	Button play, settings, scoreboard;
	Image FT;
	ImageView FTView;
	Image Play;
	
	public MainMenu() {
		FT = new Image("Tower_1_Standby.gif");
		FTView = new ImageView(FT);
		Play = new Image("PLAY1.png");
		play = new Button("");
		settings = new Button("");
		scoreboard = new Button("");
		play.setPrefSize(400, 50);
		//play.setGraphic(new ImageView(Play));
		play.setStyle("-fx-background-image: url('PLAY1.png')");
		settings.setStyle("-fx-background-image: url('SETTING.png')");
		scoreboard.setStyle("-fx-background-image: url('SCOREBOARD.png')");
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
		
		setStyle("-fx-background-image: url('icecream4.gif'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch; "
				+ "-fx-background-size: 1200 800;");
		getChildren().addAll(play,settings,scoreboard, FTView);
	}
	
}
