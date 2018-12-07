package logic;

import java.util.ArrayList;

import application.Field;
import application.GameScreen;
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
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				//Field.getCanvas().clear();
			}
		};
		animation.start();
	}
}
