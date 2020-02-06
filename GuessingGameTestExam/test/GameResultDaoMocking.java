import java.util.ArrayList;
import java.util.List;

import domain.GameResult;
import domain.GameResultDAO;

public class GameResultDaoMocking implements GameResultDAO {
	
	List<GameResult> list = new ArrayList<>();

	@Override
	public void createResult(GameResult gameResult) {
		list.add(gameResult);
	}

	@Override
	public List<GameResult> getTopTen() {
		
		return list;
	}

}
