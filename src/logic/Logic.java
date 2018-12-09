package logic;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;

public class Logic {
	private GameScreen gameScreen;
	
	public Logic() {
		gameScreen = new GameScreen();
		//Target t1 = ((Target) new Broccoli());
		//Target t2 = ((Target) new Broccoli());
		//Target t3 = ((Target) new Onion());
		//Target t4 = ((Target) new Onion()); 
		//gameScreen.getField().addTarget(t1);
		//gameScreen.getField().addTarget(t2);
		//gameScreen.getField().addTarget(t3);
		//gameScreen.getField().addTarget(t4);
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
				//Deck.update();
				countTimer++;
			}
		};
		animation.start();
	}
}
