package another;

import java.util.Scanner;

public class LotteInput {
	Scanner sc = null;
	
	public LotteInput() {
		sc = new Scanner(System.in);
	}
	
	String choiceDayNight() throws Exception {
		LotteCalcul lc = new LotteCalcul();
		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		int inputSelectTicket = sc.nextInt();

		return lc.calculDayNightTicket(inputSelectTicket);
	}

	String[] inputSocialNumber() throws Exception {
		LotteCalcul lc = new LotteCalcul();
		System.out.printf("주민등록번호를 입력하세요\n");
		String socialNumber = sc.nextLine(); // 123456-1234567에서 '-' 빼고 입력

		return lc.calculSocialNumber(socialNumber);
	}

	int countNumber() throws Exception {
		LotteCalcul lc = new LotteCalcul();
		System.out.printf("몇 개를 주문하시겠습니까? (최대 10개)\n");
		int numberOfOrders = sc.nextInt();

		return lc.calculCountNumbers(numberOfOrders);
	}

	double treatment() throws Exception {
		LotteCalcul lc = new LotteCalcul();
		int specificCase;
		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음 (나이 우대는 자동처리)\n"); // 65세 이상은 어린이 요금과 동일하게 처리
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");
		specificCase = sc.nextInt();

		return lc.calculTreatment(specificCase);
	}

	int guideComment() throws Exception {
		LotteCalcul lc = new LotteCalcul();
		int selectContinue;

		System.out.printf("\n계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
		selectContinue = sc.nextInt();

		return lc.decideContinue(selectContinue);
	}

	void removeEnter() {
		sc.nextLine();
	}
}