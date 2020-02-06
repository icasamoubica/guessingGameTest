import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import buisness.GuessingGameController;
//import org.junit.jupiter.api.timeout;

class GuessingGameControllerTest {

	UserEnviromentMocking ui;
	GuessingGameMocking gg;
	GuessingGameController ggc;
	GameResultDaoMocking gr;
	
	@BeforeEach
	void init() {
		gg = new GuessingGameMocking();
		ui = new UserEnviromentMocking();
		gr = new GameResultDaoMocking();
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
		assertEquals(5, gg.getNumberOfGuesses()); // Ui returns int that increases after every getInt() method. 
		  															// the GuessingGame will return correct if ui sends 5
		
		
	}
	
	@Test
	void testGameWithDao() {
		ggc = new GuessingGameController(ui, gg, gr);
		ggc.playGame();
		assertEquals(5, gg.getNumberOfGuesses());
		assertTrue(ui.getString().contentEquals("end"));
		assertTrue(ggc.getGameResults()!=null);
	}
	
	@Test
	void testDaoCreate() {
		
		ggc = new GuessingGameController(ui, gg, gr);
		assertTrue(gr.getTopTen().isEmpty());
		
		ggc.playGame();
		assertTrue(gr.getTopTen().get(0).getPlayerName().equalsIgnoreCase("no") &&
				gr.getTopTen().get(0).getNumberOfGuesses()==5);
	}
	
	@Test
	void testDaoGetTopTen() {
		ggc = new GuessingGameController(ui, gg, gr);
		ggc.playGame();
		assertTrue(gr.getTopTen()!=null);
	}
	
	@Test 
	void testAddStringAmmount() {
		// Without ResultDao and with GuessingGameMocking there should be 9 calls to addString() from GameContrioller
		int expected = 9;
		
		ggc = new GuessingGameController(ui, gg);
		ggc.playGame();
		
		assertEquals(expected, ui.getStringAdded());
		
	}

}
