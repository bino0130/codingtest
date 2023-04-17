package another;

public class ExchangeMoney {

	public static void main(String[] args) {
		int moneyKOR = 0;
		int inputChangeType = 0;
		InputClass inputClass = new InputClass();
		do {
			moneyKOR = inputClass.inputFromConsoleWon();
			inputChangeType = inputClass.inputFromConsoleType();
			
			RunExchangeClass runClass = new RunExchangeClass();
			
			switch (inputChangeType) {
				case ExchangeMoneyRate.CHANGE_TYPE_USD: // 환전할 화폐가 결정되면 RunExchangeClass에 값 전달
					runClass.changeToUSD(moneyKOR);
					break;
				case ExchangeMoneyRate.CHANGE_TYPE_EUR:
					runClass.changeToEUR(moneyKOR);
					break;
				case ExchangeMoneyRate.CHANGE_TYPE_JPY:
					runClass.changeToJPY(moneyKOR);
					break;
				case ExchangeMoneyRate.CHANGE_TYPE_CNY:
					runClass.changeToCNY(moneyKOR);
					break;
			}
		}while (inputChangeType != 0);		
	}

}