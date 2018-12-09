package logic;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;

public class Logic {
	private GameScreen gameScreen;
	
	public Logic() {
		gameScreen = new GameScreen();
		Target t1 = ((Target) new Broccoli());
		Target t2 = ((Target) new Broccoli());
		gameScreen.getField().addTarget(t1);
		gameScreen.getField().addTarget(t2);
		
		startGameLoop();
	}
	public void startGameLoop() {
		AnimationTimer animation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				System.out.println("time : " + now);
				
				Field.update();
				//Deck.update();
			}
		};
		animation.start();
	}
}
