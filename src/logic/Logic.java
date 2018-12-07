package logic;

import java.util.ArrayList;

import application.Field;
import application.GameScreen;
import javafx.animation.AnimationTimer;

public class Logic {
	private GameScreen gameScreen;
	
	public Logic() {
		gameScreen = new GameScreen();
		Target t1 = new Target("Zombie_1");
		Target t2 = new Target("Zombie_1");
		Field.getTargets().add(t1);
		Field.getTargets().add(t2);
		gameScreen.getField().addTarget(t1);
		gameScreen.getField().addTarget(t2);
		
		startGameLoop();
	}
	public void startGameLoop() {
		AnimationTimer animation = new AnimationTimer() {
			@Override
			public void handle(long now) {
				Field.update();
			}
		};
		animation.start();
	}
}
