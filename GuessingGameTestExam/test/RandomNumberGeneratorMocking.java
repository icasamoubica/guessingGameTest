import buisness.RandomNumberGeneratorInterface;

public class RandomNumberGeneratorMocking implements RandomNumberGeneratorInterface{

	public int randomNumber;
	
	
	@Override
	public int getRandomNumber() {
		return randomNumber;
	}

	@Override
	public void generateRandomNumber(int range) {
		this.randomNumber = range;
	}

}
