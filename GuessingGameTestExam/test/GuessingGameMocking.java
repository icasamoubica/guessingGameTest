import buisness.GuessResult;
import buisness.GuessingGameInterface;
import buisness.RandomNumberGeneratorInterface;

public class GuessingGameMocking implements GuessingGameInterface {

	int guess = 1;
	int numberOfGuesses;
	private int numberOfGames = 0;

	@Override
	public void newGame() {
		numberOfGames++;
	}

	@Override
	public GuessResult makeGuess(int guess) {
		numberOfGuesses++;
		if (guess == 5)
			return GuessResult.correct;
		else if (guess == 4)
			return GuessResult.tooSmall;
		else if (guess == 3)
			return GuessResult.tooSmallButClose;
		else if (guess == 2)
			return GuessResult.tooLarge;
		else 
			return GuessResult.tooLargeButClose;
	}

	@Override
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	@Override
	public RandomNumberGeneratorInterface getRandomNumberGenerator() {
		return null;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return 0;
	}

}
