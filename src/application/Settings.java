package application;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


public class Settings extends VBox {
	Button volume_button;
	CheckBox mute;
	Slider volume_slider;
	HBox volume_menu;
	public Settings() {
		volume_button = new Button("Volume");
		volume_slider = new Slider();
		mute = new CheckBox();
		volume_menu = new HBox();
		volume_menu.getChildren().addAll(volume_button,volume_slider);
		getChildren().addAll(volume_menu,mute);
		
	}
	
}
