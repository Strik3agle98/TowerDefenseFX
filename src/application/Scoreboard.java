package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.User;

//sorted solely by score atm
public class Scoreboard extends VBox{
	private Button back;
	private ObservableList<Label> logDataList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	private int count = 1;
	private ArrayList<User> top5 = new ArrayList<User>();
	
	public Scoreboard() {
		setPadding(new Insets(20,20,20,20));
		setAlignment(Pos.CENTER);
		setSpacing(20);
		logListView = new ListView<Label>(logDataList);
		//getUserData(logDataList);
		logListView.setPrefHeight(500);
		logListView.setMaxWidth(500);
		//logListView.set
		logListView.setFocusTraversable(false);
		//logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		//logListView.setPlaceholder(new Label("No Votes"));
		
		back = new Button("");
		back.setPrefSize(200, 50);
		back.setStyle("-fx-background-image: url('BACK.png')");
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
		getChildren().addAll(logListView, back);
		
		top5 = GUI.getData().getTop5();
		for(User u: top5) {
			addData(u.getName(), u.getMaxScore());
		}
	}
	
	public void addData(String name, int score) {
		Label newLabel = new Label(count++ + ") " + name + ":\t" + score);
		newLabel.setFont(Font.font("Verdana", 55));
		logDataList.add(newLabel);
		logListView.scrollTo(newLabel);
	}
	
	public void clearData() {
		logDataList.clear();
		count = 1;
	}
}
