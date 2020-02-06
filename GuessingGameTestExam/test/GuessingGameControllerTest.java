import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import buisness.GuessingGameController;
import buisness.GuessingGameInterface;
import userinterface.UI;

class GuessingGameControllerTest {

	UserEnviromentMocking ui;
	GuessingGameMocking gg;
	GuessingGameController ggc;
	
	@BeforeEach
	void init() {
		gg = new GuessingGameMocking();
		ui = new UserEnviromentMocking();
	}
	
	
	@Test
	void testPlayGame() {
		ggc = new GuessingGameController(ui, gg);
		ggc.playGame();
		
		assertTrue(ui.getString().contentEquals("end")); // ui.close() changes String field in ui to "End". Get string gets that string.
	}
	
	@Test
	void testGetNumberOfGuesses() {
		ggc = new GuessingGameController(ui, gg);
		ggc.playGame();
		assertEquals(5, gg.getNumberOfGuesses()); // Ui returns int that increses after every getInt() method. 
		  															// the GuessingGame will return correct if ui sends 5
		
		
	}
	
	@Test
	void testGameWithDao() {
		ggc = new GuessingGameController(ui, gg, new GameResultDaoMocking());
		ggc.playGame();
		assertEquals(5, gg.getNumberOfGuesses());
		assertTrue(ui.getString().contentEquals("end"));
		assertTrue(ggc.getGameResults()!=null);
	}
	
	@Test
	void testDaoCreate() {
		ggc = new GuessingGameController(ui, gg, new GameResultDaoMocking());
		assertTrue(ggc.getGameResults().getTopTen().isEmpty());
		ggc.playGame();
		assertTrue(ggc.getGameResults().getTopTen().get(0).getPlayerName().equalsIgnoreCase("no") &&
				ggc.getGameResults().getTopTen().get(0).getNumberOfGuesses()==5);
	}
	
	@Test
	void testDaoGetTopTen() {
		ggc = new GuessingGameController(ui, gg, new GameResultDaoMocking());
		ggc.playGame();
		assertTrue(ggc.getGameResults().getTopTen()!=null);
	}

}
