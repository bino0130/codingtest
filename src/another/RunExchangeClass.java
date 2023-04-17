package another;

public class RunExchangeClass {
	public OutputClass outClass = null;
	
	public RunExchangeClass() {
		outClass = new OutputClass();
	}
	private boolean checkBalanceUSD(int requestUSD) {
		if(requestUSD <= ExchangeMoneyRate.BALANCE_USD) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkBalanceEUR(int requestEUR) {
		if(requestEUR <= ExchangeMoneyRate.BALANCE_EUR) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkBalanceJPY(int requestJPY) {
		if(requestJPY <= ExchangeMoneyRate.BALANCE_JPY) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkBalanceCNY(int requestCNY) {
		if(requestCNY <= ExchangeMoneyRate.BALANCE_CNY) {
			return true;
		} else {
			return false;
		}
	}
	
	public void changeToUSD(int moneyKOR) {
		double returnUSD;
		int returnRealUSD;
		int charge;
		
		returnUSD = moneyKOR / ExchangeMoneyRate.EX_USD;
		returnRealUSD = (int)returnUSD;	
		if(checkBalanceUSD(returnRealUSD)) { // 환전해 줄 금액이 재고보다 큰지 작은지 확인
			outClass.outputResultUSD(returnRealUSD);
			
			charge = (int) (moneyKOR - returnRealUSD * ExchangeMoneyRate.EX_USD);
			charge = (charge / 10) * 10;  	
			
			outClass.outputResultWon(charge);
			ExchangeMoneyRate.BALANCE_USD -= returnRealUSD;
		} else {
			outClass.printErrorMessage(ExchangeMoneyRate.ERR_BALANCE_USD);
		}
	}
	public void changeToEUR(int moneyKOR) {
		double returnEUR;
		int returnRealEUR;
		int charge;
		returnEUR = moneyKOR / ExchangeMoneyRate.EX_EUR;
		returnRealEUR = (int)returnEUR;	
		
		if(checkBalanceEUR(returnRealEUR)) {
			System.out.println(returnRealEUR + " 유로");
			System.out.println("500 유로 지폐 " 
								+ (returnRealEUR / 500) + " 장 ");
			System.out.println("100 유로 지폐 " 
								+ ((returnRealEUR % 500) / 100) + " 장 ");
			System.out.println("50 유로 지폐 " 
								+ (((returnRealEUR % 500) % 100) / 50) + " 장 ");
			System.out.println("20 유로 지폐 " 
								+ ((((returnRealEUR % 500) % 100) % 50) / 20) + " 장 ");
			System.out.println("10 유로 지폐 " 
								+ (((((returnRealEUR % 500) % 100) % 50) % 20) / 10) + " 장 ");
			System.out.println("5 유로 지폐 " 
								+ ((((((returnRealEUR % 500) % 100) % 50) % 20) % 10) / 5) + " 장 ");																				
			System.out.println("2 유로 지폐 " 
								+ ((returnRealEUR % 5) / 2) + " 장 ");
			System.out.println("1 유로 지폐 " 
								+ (((returnRealEUR % 5)) % 2) + " 장 ");
						
			charge = (int) (moneyKOR - returnRealEUR * ExchangeMoneyRate.EX_EUR);
			charge = (charge / 10) * 10;  	
			
			outClass.outputResultWon(charge);
			ExchangeMoneyRate.BALANCE_EUR -= returnRealEUR;
		} else {
			outClass.printErrorMessage(ExchangeMoneyRate.ERR_BALANCE_EUR);
		}
	}
	public void changeToJPY(int moneyKOR) {
		double returnJPY;
		int returnRealJPY;
		int charge;
		returnJPY = moneyKOR / ExchangeMoneyRate.EX_JPY;
		returnRealJPY = (int)returnJPY;		
		
		if(checkBalanceJPY(returnRealJPY)) {
			System.out.println(returnRealJPY + " 엔 ");
			System.out.println("10000 엔 지폐 " 
								+ (returnRealJPY / 10000) + " 장 ");
			System.out.println("5000 엔 지폐 " 
								+ ((returnRealJPY % 10000) / 5000) + " 장 ");
			System.out.println("1000 엔 지폐 " 
								+ (((returnRealJPY % 10000) % 5000) / 1000) + " 장 ");
			System.out.println("500 엔 동전 " 
								+ ((((returnRealJPY % 10000) % 5000) % 1000) / 500) + " 개 ");
			System.out.println("100 엔 동전 " 
								+ (((((returnRealJPY % 10000) % 5000) % 1000) % 500) / 100) + " 개 ");
							
			charge = (int) (moneyKOR - returnRealJPY * ExchangeMoneyRate.EX_JPY);
			charge = (charge / 10) * 10;  	
			
			outClass.outputResultWon(charge);
		} else {
			outClass.printErrorMessage(ExchangeMoneyRate.ERR_BALANCE_JPY);
		}
				
	}
	public void changeToCNY(int moneyKOR) {
		double returnCNY;
		int returnRealCNY;
		int charge;
		returnCNY = moneyKOR / ExchangeMoneyRate.EX_CNY;
		returnRealCNY = (int)returnCNY;		
		
		if (checkBalanceCNY(returnRealCNY)) {
			System.out.println(returnRealCNY + "위안");
			System.out.println("100 위안 지폐 " 
								+ (returnRealCNY / 100) + " 장 ");
			System.out.println("50 위안 지폐 " 
								+ ((returnRealCNY % 100) / 50) + " 장 ");
			System.out.println("20 위안 지폐" 
								+ (((returnRealCNY % 100) % 50) / 20) + " 장 ");
			System.out.println("10 위안 동전" 
								+ ((((returnRealCNY % 100) % 50) % 20) / 10) + " 개 ");
			System.out.println("5 위안 동전" 
								+ (((((returnRealCNY % 100) % 50) % 20) % 10) / 5) + " 개 ");
			System.out.println("1 위안 동전" 
					+ ((((((returnRealCNY % 100) % 50) % 20) % 10) % 5) / 1) + " 개 ");
							
			charge = (int) (moneyKOR - returnRealCNY * ExchangeMoneyRate.EX_CNY);
			charge = (charge / 10) * 10;  	
			
			outClass.outputResultWon(charge);	
		} else {
			outClass.printErrorMessage(ExchangeMoneyRate.ERR_BALANCE_CNY);
		}
	}
}



