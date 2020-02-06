import userinterface.UI;

public class UserEnviromentMocking implements UI {
	
	public int guess= 0;
	String string = "no";
	
	@Override
	public String getString() {
		return string;
	}

	@Override
	public int getInt() {
		guess++;
		return guess;
	}

	@Override
	public void addString(String s) {
		System.out.println(s);
	}

	@Override
	public void clear() {}

	@Override
	public void exit() {
		this.string = "end";
	}
	

}
