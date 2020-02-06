import buisness.GuessResult;
import buisness.GuessingGameInterface;
import buisness.RandomNumberGeneratorInterface;

public class GuessingGameMocking implements GuessingGameInterface {

	int guess = 1;
	int numberOfGuesses;

	@Override
	public void newGame() {
	}

	@Override
	public GuessResult makeGuess(int guess) {
		numberOfGuesses++;
		if (guess == 5)
			return GuessResult.correct;
		else
			return GuessResult.tooSmall;
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
