import java.util.Scanner;

public class UserInput {

	private Scanner scnr = new Scanner(System.in);
	
	public String readString (String promptMsg, String errorMsg) {
		String inputReturn = " ";
		boolean valid = false;
		while (valid == false) {
			System.out.println(promptMsg);
			String input = scnr.nextLine();
			if(input.equalsIgnoreCase("book")) {
				inputReturn = input;
				valid = true;
			} else if(input.equalsIgnoreCase("game")) {
				inputReturn = input;
				valid = true;
			} else if (input.equalsIgnoreCase("movie")) {
				inputReturn = input;
				valid = true;
			} else {
				System.out.println(errorMsg);
			}
		}
		return inputReturn;
	}
	
	public String readRandom (String promptMsg) {
		System.out.println(promptMsg);
		String inputReturn = scnr.nextLine();
		return inputReturn;
	}
	
	public int readInteger (String promptMsg, String errorMsg) {
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while (valid == false) {
			System.out.println(promptMsg);
			strInput = scnr.nextLine();
			try {
				num = Integer.parseInt(strInput);
				valid = true;
			} catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	public int readInteger (String promptMsg, String errorMsg, int low, int hi) {
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while (valid == false) {
			System.out.println(promptMsg);
			strInput = scnr.nextLine();
			try {
				num = Integer.parseInt(strInput);
				if (num >= low && num <= hi) {
					valid = true;
				} else {
					System.out.println(errorMsg);
				}
			} catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
}
