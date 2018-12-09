package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.Logic;
import javafx.scene.layout.HBox;
public class NameEntering extends VBox{
	private TextField name;
	private Button enter,back;
	private HBox group1,group2;
	private Text t1;
	public NameEntering() {
		group1 = new HBox();
		t1 = new Text("Please enter your username:");
		name = new TextField();
		name.setPrefWidth(200);
		name.setPromptText("John Smith");
		group1.getChildren().addAll(t1,name);
		group1.setAlignment(Pos.CENTER_LEFT);
		group1.setSpacing(10);
		enter = new Button("");
		back = new Button("");
		group2 = new HBox();
		group2.getChildren().addAll(back,enter);
		group2.setSpacing(20);
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed back.");
				GUI.getStage().setScene(GUI.getSceneOfMainMenu());
			}
		});
		back.setCursor(Cursor.HAND);
		enter.setPrefSize(200, 50);
		enter.setStyle("-fx-background-image: url('PROCEED.png')");
		back.setPrefSize(200, 50);
		back.setStyle("-fx-background-image: url('BACK.png')");
		enter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed enter.");
				User new_user = new User(name.getText());
				GUI.getData().addUser(new_user);
				//save name and load game....
				new Logic();
				GUI.getStage().setScene(GUI.getSceneOfGameScreen());
			}
		});
		enter.setCursor(Cursor.HAND);
		setSpacing(20);
		setPadding(new Insets(20,20,20,20));
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-image: url('BGL.jpg'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch; "
				+ "-fx-background-size: 1200 800;");
		getChildren().addAll(group1,group2);
	}
	
}
