package buisness;

import domain.GameResult;
import domain.GameResultDAO;
import userinterface.UI;

public class GuessingGameController {

	private GuessingGameInterface game;
	private UI ui;
	private GameResultDAO gameResults;
	private String playerName; // Player's name should be committed to db upon competition of one game, if there is dbDao

	public GuessingGameController(UI ui, GuessingGameInterface game) {
		this.ui = ui;
		this.game = game;
	}

	public GuessingGameController(UI ui, GuessingGameInterface game, GameResultDAO gameResultDao) {
		this.ui = ui;
		this.game = game;
		this.gameResults = gameResultDao;
	}

	public void playGame() {

		// If there is game result database
		if (gameResults != null) {
			ui.addString("Player name?\n");
			playerName = ui.getString();
		}

		// Game instance starts here
		String input = "yes";
		while (!input.equals("no")) {
			ui.addString("New game, range is 1 to " + game.getRange() + "\n");
			ui.addString("Start guessing\n");
			GuessResult result = null;
			while (result != GuessResult.correct) {
				int guess = ui.getInt();
				result = game.makeGuess(guess);
				ui.addString(guess + " is " + result + "\n");
			}
			ui.addString("You did it in " + game.getNumberOfGuesses() + " guesses\n");

			if (gameResults != null) {
				gameResults.createResult(new GameResult(playerName, game.getNumberOfGuesses()));

				if (!gameResults.getTopTen().isEmpty()) {
					ui.addString("Top 10!\n");
					int position=0;
					for (GameResult gameResult : gameResults.getTopTen())
						ui.addString(position++ + ". " + gameResult.getPlayerName() + ": " + gameResult.getNumberOfGuesses());
				}
			}

			ui.addString("Another game?\n");
			input = ui.getString();
			game.newGame();

		}
		ui.exit();

	}
	
	public GameResultDAO getGameResults() {
		return this.gameResults;
	}
}
