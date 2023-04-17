package another;

public class OutputClass {
	
	private void printResultUSD(int returnRealUSD, 
								int outputUSD100, int outputUSD50, int outputUSD10,
								int outputUSD5, int outputUSD2, int outputUSD1) {
		System.out.println(returnRealUSD + " dollar");
		System.out.println("100 달러 지폐 " 
							+ outputUSD100 + " 장 ");
		System.out.println("50 달러 지폐" 
							+ outputUSD50 + " 장 ");
		System.out.println("10 달러 지폐 " 
							+ outputUSD10 + " 장 ");
		System.out.println("5 달러 지폐 " 
							+ outputUSD5 + " 장 ");
		System.out.println("2 달러 지폐 " 
							+ outputUSD2 + " 장 ");
		System.out.println("1 달러 지폐 " 
							+ outputUSD1 + " 장 ");
	}
	
	private void printResultWon(int charge, 
								int returnWon1000, int returnWon500, int returnWon100,
								int returnWon50, int returnWon10) {
		System.out.println("\n잔돈 = " 
				+ charge + " 원 ");
		System.out.println("1000 원 지폐 " 
						+ returnWon1000 + " 장 ");
		System.out.println("500 원 동전 " 
						+ returnWon500  + " 개 ");
		System.out.println("100 원 동전 " 
						+ returnWon100  + " 개 ");
		System.out.println("50 원 동전 " 
						+ returnWon50 + " 개 ");
		System.out.println("10 원 동전 " 
						+ returnWon10 + " 개 ");		
	}
	
	public void printErrorMessage(int errorCode) {
		switch(errorCode) {
			case ExchangeMoneyRate.ERR_BALANCE_USD:
				System.out.print("달러 ");
				break;
			case ExchangeMoneyRate.ERR_BALANCE_EUR:
				System.out.print("유로 ");
				break;
			case ExchangeMoneyRate.ERR_BALANCE_JPY:
				System.out.print("앤화 ");
				break;
			case ExchangeMoneyRate.ERR_BALANCE_CNY:
				System.out.print("위안화 ");
				break;
		}
		System.out.println("보유 잔액이 부족합니다.");
	}
	public void outputResultUSD(int returnRealUSD) {
		int outputUSD100, outputUSD50, outputUSD10;
		int outputUSD5, outputUSD2, outputUSD1;
		
		outputUSD100 = (returnRealUSD / ExchangeMoneyRate.CHANGE_USD_100);
		outputUSD50 = ((returnRealUSD % ExchangeMoneyRate.CHANGE_USD_100)) / 50;
		outputUSD10 = (((returnRealUSD % ExchangeMoneyRate.CHANGE_USD_100)) % 50) / 10;
		outputUSD5 = ((((returnRealUSD % ExchangeMoneyRate.CHANGE_USD_100)) % 50) % 10) / 5;
		outputUSD2 = (((((returnRealUSD % ExchangeMoneyRate.CHANGE_USD_100)) % 50) % 10) % 5) / 2;
		outputUSD1 = ((((((returnRealUSD % ExchangeMoneyRate.CHANGE_USD_100)) % 50) % 10) % 5) % 2);
		
		printResultUSD(returnRealUSD, 
						outputUSD100, outputUSD50, outputUSD10, 
						outputUSD5, outputUSD2, outputUSD1);
		System.out.println(returnRealUSD + " dollar");
	}
	public void outputResultEUR(int returnRealEUR) {
		int outputEUR500, outputEUR200, outputEUR100;
		int outputEUR50, outputEUR20, outputEUR10, outputEUR5, outputEUR2, outputEUR1;
		
		outputEUR500 = (returnRealEUR / ExchangeMoneyRate.CHANGE_EUR_500);
		outputEUR200 = ((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) / 200;
		outputEUR100 = (((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) / 100;
		outputEUR50 = ((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) / 50;
		outputEUR20 = (((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) % 50) / 20;
		outputEUR10 = ((((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) % 50) % 20) / 10;
		outputEUR5 = (((((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) % 50) % 20) % 10) / 5;
		outputEUR2 = ((((((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) % 50) % 20) % 10) % 5) / 2;
		outputEUR1 = (((((((((returnRealEUR % ExchangeMoneyRate.CHANGE_EUR_500)) % 200) % 100) % 50) % 20) % 10) % 5) % 2) / 1;
		
		printResultEUR(returnRealEUR, 
				outputEUR500, outputEUR200, outputEUR100, 
				outputEUR50, outputEUR20, outputEUR10, outputEUR5, outputEUR2, outputEUR1);
	}
	public void printResultEUR(int returnRealEUR, int outputEUR500, int outputEUR200, int outputEUR100,
			int outputEUR50, int outputEUR20, int outputEUR10, int outputEUR5, int outputEUR2, int outputEUR1) {
		System.out.println(returnRealEUR + " Euro");
		System.out.println("500 유로 지폐 " + outputEUR500 + "장");
		System.out.println("200 유로 지폐 " + outputEUR200 + "장");
		System.out.println("100 유로 지폐 " + outputEUR100 + "장");
		System.out.println("50 유로 지폐 " + outputEUR50 + "장");
		System.out.println("20 유로 지폐 " + outputEUR20 + "장");
		System.out.println("10 유로 지폐 " + outputEUR10 + "장");
		System.out.println("5 유로 지폐 " + outputEUR5 + "장");
		System.out.println("2 유로 지폐 " + outputEUR2 + "장");
		System.out.println("1 유로 지폐 " + outputEUR1 + "장");
	}

	public void outputResultJPY(int returnRealJPY) {
		int outputJPY10000, outputJPY5000, outputJPY1000;
		int outputJPY500, outputJPY100, outputJPY50;
		
		outputJPY10000 = (returnRealJPY / ExchangeMoneyRate.CHANGE_JPY_10000);
		outputJPY5000 = ((returnRealJPY % ExchangeMoneyRate.CHANGE_JPY_10000)) / 5000;
		outputJPY1000 = (((returnRealJPY % ExchangeMoneyRate.CHANGE_JPY_10000)) % 5000) / 1000;
		outputJPY500 = ((((returnRealJPY % ExchangeMoneyRate.CHANGE_JPY_10000)) % 5000) % 1000) / 500;
		outputJPY100 = (((((returnRealJPY % ExchangeMoneyRate.CHANGE_JPY_10000)) % 5000) % 1000) % 500) / 100;
		outputJPY50 = ((((((returnRealJPY % ExchangeMoneyRate.CHANGE_JPY_10000)) % 5000) % 1000) % 500) % 100) / 50;
		
		printResultJPY(returnRealJPY, 
				outputJPY10000, outputJPY5000, outputJPY1000, 
				outputJPY500, outputJPY100, outputJPY50);
	}
	private void printResultJPY(int returnRealJPY, int outputJPY10000, int outputJPY5000, int outputJPY1000,
			int outputJPY500, int outputJPY100, int outputJPY50) {
		System.out.println(returnRealJPY + " Yen");
		System.out.println("10000엔 지폐 " + outputJPY10000 + "장");
		System.out.println("5000엔 지폐 " + outputJPY5000 + "장");
		System.out.println("1000엔 지폐 " + outputJPY1000 + "장");
		System.out.println("500엔 지폐 " + outputJPY500 + "장");
		System.out.println("100엔 지폐 " + outputJPY100 + "장");
		System.out.println("50엔 지폐 " + outputJPY50 + "장");
	}

	public void outputResultCNY(int returnRealCNY) {
		int outputCNY100, outputCNY50, outputCNY20;
		int outputCNY10, outputCNY5, outputCNY1;
		
		outputCNY100 = (returnRealCNY / ExchangeMoneyRate.CHANGE_CNY_100);
		outputCNY50 = ((returnRealCNY % ExchangeMoneyRate.CHANGE_CNY_100)) / 50;
		outputCNY20 = (((returnRealCNY % ExchangeMoneyRate.CHANGE_CNY_100)) % 50) / 20;
		outputCNY10 = ((((returnRealCNY % ExchangeMoneyRate.CHANGE_CNY_100)) % 50) % 20) / 10;
		outputCNY5 = (((((returnRealCNY % ExchangeMoneyRate.CHANGE_CNY_100)) % 50) % 20) % 10) / 5;
		outputCNY1 = ((((((returnRealCNY % ExchangeMoneyRate.CHANGE_CNY_100)) % 50) % 20) % 10) % 5) / 1;
		
		printResultCNY(returnRealCNY, 
						outputCNY100, outputCNY50, outputCNY20, 
						outputCNY10, outputCNY5, outputCNY1);
		
	}
	private void printResultCNY(int returnRealCNY, int outputCNY100, int outputCNY50, int outputCNY20, int outputCNY10,
			int outputCNY5, int outputCNY1) {
		System.out.println(returnRealCNY + " Yen");
		System.out.println("100위안 지폐 " + outputCNY100 + "장");
		System.out.println("50위안 지폐 " + outputCNY50 + "장");
		System.out.println("20위안 지폐 " + outputCNY20 + "장");
		System.out.println("10위안 지폐 " + outputCNY10 + "장");
		System.out.println("5위안 지폐 " + outputCNY5 + "장");
		System.out.println("1위안 지폐 " + outputCNY1 + "장");
	}

	public void outputResultWon(int charge) {
		int returnWon1000, returnWon500, returnWon100, returnWon50, returnWon10;
		returnWon1000 = charge / 1000;
		returnWon500 = (charge % 1000) / 500;
		returnWon100 = ((charge % 1000) % 500) / 100;
		returnWon50 = (((charge % 1000) % 500) % 100) / 50;
		returnWon10 = ((((charge % 1000) % 500) % 100) % 50) / 10;
		
		printResultWon(charge, 
						returnWon1000, returnWon500, returnWon100, 
						returnWon50, returnWon10);
	}
}
