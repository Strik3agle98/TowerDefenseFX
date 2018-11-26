package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
public class NameEntering extends VBox{
	private TextField name;
	private Button enter,back;
	private HBox group1,group2;
	private Text t1;
	private FileWriter fw;
	public NameEntering() {
		group1 = new HBox();
		t1 = new Text("Please enter your username:");
		name = new TextField("John Smith");
		name.setPrefWidth(200);
		group1.getChildren().addAll(t1,name);
		group1.setAlignment(Pos.CENTER_LEFT);
		group1.setSpacing(10);
		enter = new Button("Proceed");
		back = new Button("Back");
		group2 = new HBox();
		group2.getChildren().addAll(back,enter);
		group2.setSpacing(20);
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed back.");
				GUI.getStage().setScene(GUI.getSceneOfMainMenu());
			}
		});
		enter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("You pressed enter.");
				User new_user = new User(name.getText());
				GUI.getData().addUser(new_user);
				//save name and load game....
				GUI.getStage().setScene(GUI.getSceneOfMap());
			}
		});
		setSpacing(20);
		setPadding(new Insets(20,20,20,20));
		setAlignment(Pos.CENTER);
		getChildren().addAll(group1,group2);
	}
	
}
