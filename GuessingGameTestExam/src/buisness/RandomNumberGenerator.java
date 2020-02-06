package buisness;

public class RandomNumberGenerator implements RandomNumberGeneratorInterface {

	private int randomNumber;

	
	@Override
	public int getRandomNumber() {
		return randomNumber;
	}
	
	@Override
	public void generateRandomNumber(int range) {
		randomNumber = (int) (Math.random() * range + 1);
	}
}
