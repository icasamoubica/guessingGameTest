import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buisness.Config;
import buisness.GuessResult;
import buisness.GuessingGame;

class GuessingGameTest {

	GuessingGame game;
	int range = Config.RANGE;
	GuessResult expectedGuessResult;

	// Initialize a fresh new instance of GuessingGame before every test
	@BeforeEach
	void initGmae() {
		game = new GuessingGame(range, new RandomNumberGeneratorMocking());
		game.newGame();
	}

	@Test // newGame() is called before every Test
	void testNewGame() {
		int expectedNumberOfGuesses = 0;
		int expectedRandomNumber = 100;
		int expectedRange = 100;

		assertEquals(expectedNumberOfGuesses, game.getNumberOfGuesses());
		assertEquals(expectedRandomNumber, game.getRandomNumberGenerator().getRandomNumber());
		assertEquals(expectedRange, game.getRange());
	}

	// Tests basic methods, getters, fields
	@Test
	void testGetRandomNumber() {
		game.getRandomNumberGenerator().generateRandomNumber(20);
		int expected = 20;
		assertEquals(expected, game.getRandomNumberGenerator().getRandomNumber());
	}

	@Test
	void testGetNumberOfGuesses() {
		int expectedNumberOfGuesses = 1;
		game.makeGuess(10);
		assertEquals(expectedNumberOfGuesses, game.getNumberOfGuesses());
	}

	@Test
	void testNumberOfGuessesNewGame() {
		int expectedNumberOfGuesses = 0;

		game.makeGuess(10);
		game.makeGuess(10);
		game.makeGuess(10);

		game.newGame();

		assertEquals(expectedNumberOfGuesses, game.getNumberOfGuesses());
	}

	@Test
	void testGetRange() {
		int expectedRange = Config.RANGE;
		assertEquals(expectedRange, game.getRange());
	}
	@Test
	void testGetRundomNumberGenerator() {
		assertTrue(game.getRandomNumberGenerator()!=null);
	}

	// Tests for checking GuessResults
	
	@Test
	void testNullGuessInput() {
		assertThrows(NumberFormatException.class, () -> {
			game.makeGuess(new Integer(null));});
		
	}
	
	@Test
	void testCorrectGuess() {

		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.correct;

		assertEquals(expectedGuessResult, game.makeGuess(50));
	}

	@Test
	void testGuessTooSmall() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmall;

		assertEquals(expectedGuessResult, game.makeGuess(25));
	}
	
	@Test
	void testGuessTooSmallMinValue() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmall;

		assertEquals(expectedGuessResult, game.makeGuess(Integer.MIN_VALUE));
	}
	
	@Test
	void testGuessTooSmallButCloseRange1() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmallButClose;

		assertEquals(expectedGuessResult, game.makeGuess(49));
	}

	@Test
	void testGuessTooSmallButCloseRange2() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmallButClose;

		assertEquals(expectedGuessResult, game.makeGuess(48));
	}

	@Test
	void testGuessTooSmallButCloseRange10() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmallButClose;

		assertEquals(expectedGuessResult, game.makeGuess(50 - Config.CLOSE_LIMIT));
	}

	@Test
	void testGuessTooSmallButCloseRange9() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmallButClose;

		assertEquals(expectedGuessResult, game.makeGuess(50 - Config.CLOSE_LIMIT + 1));
	}

	@Test
	void testGuessTooSmallButCloseMiddleRange() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooSmallButClose;

		assertEquals(expectedGuessResult, game.makeGuess(45));
	}

	@Test
	void testGuessTooLarge() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLarge;

		assertEquals(expectedGuessResult, game.makeGuess(75));
	}
	
	@Test
	void testGuessTooLargeMaxValue() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLarge;

		assertEquals(expectedGuessResult, game.makeGuess(Integer.MAX_VALUE));
	}


	@Test
	void testGuessTooLargeButCloseRange10() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLargeButClose;

		assertEquals(expectedGuessResult, game.makeGuess(50 + Config.CLOSE_LIMIT));
	}

	@Test
	void testGuessTooLargeButCloseRange9() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLargeButClose;

		assertEquals(expectedGuessResult, game.makeGuess(50 + Config.CLOSE_LIMIT - 1));
	}

	@Test
	void testGuessTooLargeButCloseRange1() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLargeButClose;

		assertEquals(expectedGuessResult, game.makeGuess(51));
	}

	@Test
	void testGuessTooLargeButCloseRange2() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLargeButClose;

		assertEquals(expectedGuessResult, game.makeGuess(52));
	}

	@Test
	void testGuessTooLargeButCloseMiddleRange() {
		game.getRandomNumberGenerator().generateRandomNumber(50);
		expectedGuessResult = GuessResult.tooLargeButClose;

		assertEquals(expectedGuessResult, game.makeGuess(55));
	}

}
