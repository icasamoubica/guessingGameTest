import userinterface.UI;

public class UserEnviromentMocking implements UI {

	public int guesses = 0;
	String string = "no";
	int stringAdded = 0;

	@Override
	public String getString() {
		if (guesses == 5)
			return "yes";
		else 
			return string;
	}

	@Override
	public int getInt() {
		++guesses;
		return guesses;
	}

	@Override
	public void addString(String s) {
		stringAdded++;
	}

	@Override
	public void clear() {
	}

	@Override
	public void exit() {
		this.string = "end";
	}

	int getStringAdded() {
		return stringAdded;
	}

}
