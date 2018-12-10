package logic;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;

public class Logic {
	private GameScreen gameScreen;
	
	public Logic() {
		gameScreen = new GameScreen();
		startGameLoop();
	}
	public void startGameLoop() {
		AnimationTimer animation = new AnimationTimer() {
			Random random = new Random();
			int countTimer = 0;
			@Override
			public void handle(long now) {
				System.out.println("time : " + now + " ,countTimer : " + countTimer);
				
				Field.update();
				Deck.update();
				
				spawn();
				countTimer++;
			}
			public void spawn() {
				if(countTimer % 200 == 0) {
					System.out.println("Spawning a target");
					int val = random.nextInt() % 2;
					if(val < 0) val += 2;
					switch(val) {
						case 0: 
							gameScreen.getField().addTarget(((Target) new Onion())); 
							System.out.println("Spawned Onion");
							break;
						case 1: 
							gameScreen.getField().addTarget(((Target) new Broccoli())); 
							System.out.println("Spawned Broccoli");
							break;
						default: break;
					}
				}
			}
		};
		animation.start();
	}
}
