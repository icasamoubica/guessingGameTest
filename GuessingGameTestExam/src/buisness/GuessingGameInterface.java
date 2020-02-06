package buisness;

public interface GuessingGameInterface {

	void newGame();

	GuessResult makeGuess(int guess);

	int getNumberOfGuesses();
	
	RandomNumberGeneratorInterface getRandomNumberGenerator();
	
	int getRange();

}