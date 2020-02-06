package domain;

import java.util.List;

public interface GameResultDAO {

	void createResult(GameResult gameResult);
	
	List<GameResult> getTopTen();
	
}
