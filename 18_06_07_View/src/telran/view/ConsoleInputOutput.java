package telran.view;


import java.util.Scanner;



public class ConsoleInputOutput implements InputOutput{
Scanner scanner=new Scanner(System.in);
	
	@Override
	public String getString(String prompt) {
		displayLine(prompt);
		return scanner.nextLine();
	}

	@Override
	public void display(Object object) {
		System.out.print(object);

	}

}
