package domain;

public class GameResult {
	
	private String playerName;
	private int numberOfGuesses;
	
	public GameResult() {}
	
	public GameResult(String playerName, int numberOfGuesses) {
		this.playerName = playerName;
		this.numberOfGuesses = numberOfGuesses;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}
	public void setNumberOfGuesses(int numberOfGuesses) {
		this.numberOfGuesses = numberOfGuesses;
	}
	
}
