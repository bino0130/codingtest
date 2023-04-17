package another;

import java.util.Scanner;

public class InputClass {
	private Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	public int inputFromConsoleWon() {
		int moneyKOR;
		System.out.println("원화 입력 : "); // 1. 원화 입력하고 exchangemoney로 리턴
		moneyKOR = sc.nextInt();
		return moneyKOR;
	}
	public int inputFromConsoleType() {
		int inputChangeType;
		System.out.println("Which money do you want?\n"
				+ "1.USD\n"  
				+ "2.EUR\n"
				+ "3.JPY\n"
				+ "4.CNY\n"
				+ "0.Exit");
		inputChangeType = sc.nextInt(); // 환전할 돈 선택하고 exchangemoney로 리턴
		return inputChangeType;
	}
}
