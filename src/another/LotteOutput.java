package another;

import java.util.List;

public class LotteOutput {
	int printAge(int age) {
		System.out.printf("나이 : %d살\n", age);

		return 0;
	}

	int printPrice(int finalPrice) {
		System.out.println("가격은 " + finalPrice + "원 입니다.");

		return finalPrice;
	}

	int printEnd(int selectContinue) {
		if (selectContinue == 2) {
			System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
		}
		return selectContinue;
	}
}