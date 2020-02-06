package main;

import buisness.Config;
import buisness.GuessingGame;
import buisness.GuessingGameController;
import buisness.GuessingGameInterface;
import buisness.RandomNumberGenerator;
import userinterface.SimpleWindow;
import userinterface.UI;

public class Main {

	public static void main(String[] args) {
		
		
		UI ui = new SimpleWindow("GuessingGame");	
		GuessingGameInterface game = new GuessingGame(Config.RANGE, new RandomNumberGenerator());
		GuessingGameController controller = new GuessingGameController(ui,game);
		controller.playGame();
	}

}
