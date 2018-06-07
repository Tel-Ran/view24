package telran.view;

public class TestAppl {

	public static void main(String[] args) {
		InputOutput console=new ConsoleInputOutput();
		int num=console.getInteger("Please enter number", 3, 5);
		console.displayLine(num);

	}

}
