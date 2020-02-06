package buisness;

public class GuessingGame implements GuessingGameInterface {
	
	private int range;
	private int numberOfGuesses;
	private RandomNumberGeneratorInterface randomNumberGenerator;
	
	public GuessingGame(int range, RandomNumberGeneratorInterface randomNumGenerator){
		this.randomNumberGenerator = randomNumGenerator;
		this.range = range;
		newGame();
	}
	
    @Override
	public void newGame() {
    	randomNumberGenerator.generateRandomNumber(range);
		numberOfGuesses = 0;
    }
	
	@Override
	public GuessResult makeGuess(int guess) {
		numberOfGuesses++;
		boolean isClose = Math.abs(guess-randomNumberGenerator.getRandomNumber()) < Config.CLOSE_LIMIT;
		if (guess < randomNumberGenerator.getRandomNumber()) {
			return isClose ? GuessResult.tooSmallButClose : GuessResult.tooSmall;
		} else if (guess > randomNumberGenerator.getRandomNumber()) {
			return isClose ? GuessResult.tooLargeButClose : GuessResult.tooLarge;
		} else {
			return GuessResult.correct;
		}			
	}

	@Override
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	@Override
	public RandomNumberGeneratorInterface getRandomNumberGenerator() {
		return this.randomNumberGenerator;
	}
	
	@Override
	public int getRange() {
		return range;
	}

}


