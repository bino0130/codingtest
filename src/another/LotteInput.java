package another;

import java.util.Scanner;

public class LotteInput {
	Scanner sc = new Scanner(System.in);
//	int language = sc.nextInt();
	
	
//	int choiceLanguage() {
//		LotteTicketPrice ltp = new LotteTicketPrice();
//		System.out.printf("언어를 선택하세요.\n");
//		System.out.printf("1. 한국어\n");
//		System.out.printf("2. 영어\n");
//		
//		ltp.LANGUAGE = sc.nextInt();
//		return ltp.LANGUAGE;
//	}
	
	String choiceDayNight(String LANGUAGE) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		LotteTicketPrice ltp = new LotteTicketPrice();
		if(LANGUAGE.equals("KR")) {
			System.out.printf("권종을 선택하세요.\n");
			System.out.printf("1. 주간권\n");
			System.out.printf("2. 야간권\n");
		} else if(LANGUAGE.equals("US")) {
			System.out.printf("Choose Ticket Type.\n");
			System.out.printf("1. Day Type\n");
			System.out.printf("2. Night Type\n");
		} else if(LANGUAGE.equals("ES")) {
			System.out.printf("Elija la campana.\n");
			System.out.printf("1. billete semanal\n");
			System.out.printf("2. billete de noche\n");
		}
		int inputSelectTicket = sc.nextInt();

		return lc.calculDayNightTicket(LANGUAGE, inputSelectTicket);
	}

	String[] inputSocialNumber(String LANGUAGE) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		if(LANGUAGE.equals("KR")) {
			System.out.printf("주민등록번호를 입력하세요.\n");
		} else if(LANGUAGE.equals("US")) {
			System.out.printf("Input Your SocialNumber\n");
		} else if(LANGUAGE.equals("ES")) {
			System.out.printf("Introduzca su número de registro de residente.\n");
		}
		String socialNumber = sc.nextLine(); // 123456-1234567에서 '-' 빼고 입력

		return lc.calculSocialNumber(LANGUAGE, socialNumber);
	}

	int countNumber(String LANGUAGE) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		if(LANGUAGE.equals("KR")) {
			System.out.printf("몇 개를 주문하시겠습니까? (최대 10개)\n");
		} else if(LANGUAGE.equals("US")) {
			System.out.printf("How many Tickets do you want to order?\n");
		} else if(LANGUAGE.equals("ES")) {
			System.out.printf("¿Cuántos quieres pedir? (Hasta 10)\n");
		}
		int numberOfOrders = sc.nextInt();

		return lc.calculCountNumbers(LANGUAGE, numberOfOrders);
	}

	double treatment(String LANGUAGE) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		int specificCase;
		if(LANGUAGE.equals("KR")) {
			System.out.printf("우대사항을 선택하세요.\n");
			System.out.printf("1. 없음 (나이 우대는 자동처리)\n"); // 65세 이상은 어린이 요금과 동일하게 처리
			System.out.printf("2. 장애인\n");
			System.out.printf("3. 국가유공자\n");
			System.out.printf("4. 다자녀\n");
			System.out.printf("5. 임산부\n");
		} else if(LANGUAGE.equals("US")) {
			System.out.printf("Choose your treatment\n");
			System.out.printf("1. X (Age treatment is auto)\n"); // 65세 이상은 어린이 요금과 동일하게 처리
			System.out.printf("2. Disabled person\n");
			System.out.printf("3. A man of national merit\n");
			System.out.printf("4. Multi-Child\n");
			System.out.printf("5. Pregnant\n");
		} else if(LANGUAGE.equals("ES")) {
			System.out.printf("Elija un trato preferencial.\n");
			System.out.printf("1. Ninguna (autoprocesamiento de bandas de edad)\n"); // 65세 이상은 어린이 요금과 동일하게 처리
			System.out.printf("2. discapacitado\n");
			System.out.printf("3. persona de mérito nacional\n");
			System.out.printf("4. muchos hijos\n");
			System.out.printf("5. mujer embarazada\n");
		}
		
		specificCase = sc.nextInt();

		return lc.calculTreatment(LANGUAGE, specificCase);
	}

	int guideComment(String LANGUAGE) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		int selectContinue;

		if(LANGUAGE.equals("KR")) {
			System.out.printf("\n계속 발권 하시겠습니까?\n");
			System.out.printf("1. 티켓 발권\n");
			System.out.printf("2. 종료\n");
		} else if(LANGUAGE.equals("US")) {
			System.out.printf("\nDo you want to continue?\n");
			System.out.printf("1. Select Ticket\n");
			System.out.printf("2. End\n");
		} else if(LANGUAGE.equals("ES")) {
			System.out.printf("\n¿Quiere seguir emitiendo billetes?\n");
			System.out.printf("1. billete\n");
			System.out.printf("2. terminación\n");
		}
		
		selectContinue = sc.nextInt();

		return lc.decideContinue(LANGUAGE, selectContinue);
	}

	void removeEnter() {
		sc.nextLine();
	}
}