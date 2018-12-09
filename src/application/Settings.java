package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;


public class Settings extends VBox {
	Button back;
	Text t1,t2,volume;
	CheckBox mute;
	Slider volume_slider;
	HBox volume_menu,mute_menu;
	public Settings() {
		t2 = new Text("Volume");
		volume_slider = new Slider();
		volume_slider.setPrefWidth(300);
		mute_menu = new HBox();
		mute = new CheckBox();
		t1 = new Text("Mute");
		mute_menu.getChildren().addAll(t1,mute);
		mute_menu.setAlignment(Pos.CENTER_LEFT);
		mute_menu.setPadding(new Insets(20,20,20,20));
		mute_menu.setSpacing(20);
		back = new Button("");
		volume_menu = new HBox();
		volume_menu.setPrefWidth(300);
		volume_menu.setPadding(new Insets(20,20,20,20));
		volume_menu.setSpacing(20);
		volume_menu.setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(20,20,20,20));
		setAlignment(Pos.CENTER);
		setSpacing(20);
		volume_menu.getChildren().addAll(t2,volume_slider);
		getChildren().addAll(volume_menu,mute_menu,back);
		back.setPrefSize(200, 50);
		back.setStyle("-fx-background-image: url('BACK.png')");
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed back.");
				if(GUI.getStage().getScene() == GUI.getSceneOfGameScreen()) {
					GUI.getStage().setScene(GUI.getSceneOfGameScreen());
				}
				else {
					GUI.getStage().setScene(GUI.getSceneOfMainMenu());
				}
			}
		});
		back.setCursor(Cursor.HAND);
		setStyle("-fx-background-image: url('BGL.jpg'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch; "
				+ "-fx-background-size: 1200 800;");
	}
	
}
