package logic;

import java.util.ArrayList;

import application.Field;
import application.GameScreen;
import javafx.animation.AnimationTimer;

public class Logic {
	private GameScreen gameScreen;
	ArrayList<Target> targets = new ArrayList<Target>();
	ArrayList<Tower> towers = new ArrayList<Tower>();
	public Logic() {
		gameScreen = new GameScreen();
		Target t1 = new Target("Zombie_1");
		Target t2 = new Target("Zombie_1");
		targets.add(t1);
		targets.add(t2);
		gameScreen.getField().addTarget(2);
		gameScreen.getField().addTarget(3);
		
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
