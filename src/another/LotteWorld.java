package another;

import java.util.Scanner;
//	롯데월드 매표소
//	권종을 입력받는다. (주간권, 야간권)
//	주민등록번호를 입력 받는다. (주민번호를 활용하여 나이를 자동계산한다.)
//	주문 개수를 입력받는다.
//	우대사항을 입력받는다. (없음, 장애인, 국가유공자, 다자녀, 임산부)
//	위의 입력을 반복할 것인지 종료할 것인지 물어본다.
//	종료를 하게되면 지금까지 주문 내역이 모두 출력된다.
//	완전 프로그램 종료를 하게 되면 현재까지의 매출 내역을 파일로 저장한다

public class LotteWorld {
	int choiceDayNight() throws Exception { // 주간권/야간권 선택
		Scanner sc = new Scanner(System.in);

		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		int selectTicket = sc.nextInt();
		if (selectTicket < 1 || selectTicket > 2) {
			throw new Exception("다시 선택하세요.");
		}
		return inputSocialNumber(selectTicket);
	}

	int inputSocialNumber(int selectTicket) throws Exception { // 주민등록번호 입력 -> 나이계산
		int birthYear = 0, birthMonth, birthDay, age;

		String ageGroup, gender;

		Scanner sc = new Scanner(System.in);

		System.out.printf("주민등록번호를 입력하세요\n");
		String socialNumber = sc.nextLine(); // 123456-1234567에서 '-' 빼고 입력

		if (socialNumber.length() == 13) {
			int yearPreFix = Integer.parseInt(socialNumber.substring(0, 2));
			int genderDigit = Character.getNumericValue(socialNumber.charAt(6));
			if (genderDigit == 1 || genderDigit == 2) {
				birthYear = 1900 + yearPreFix;
			} else {
				birthYear = 2000 + yearPreFix;
			}
		} else {
			throw new Exception("주민등록번호는 13자리입니다.");
		}

		age = 2023 - birthYear + 1; // 나이계산
		if (age < 1 || age > 105) {
			throw new Exception("잘못된 나이입니다.");
		}
		System.out.printf("나이 : %d살\n", age);

		ageGroup = getAgeGroup(age);
		gender = judgeFemale(socialNumber);
		return calculPrice(selectTicket, ageGroup, gender);
	}

	String getAgeGroup(int age) { // 나이 받아서 연령대 리턴
		if (age >= 65) {
			return "노인";
		} else if (age >= 20 && age <= 64) {
			return "성인";
		} else if (age >= 13 && age <= 19) {
			return "청소년";
		} else if (age >= 3 && age <= 12) {
			return "어린이";
		} else if (age >= 1 && age <= 2) {
			return "베이비";
		} else {
			return "error";
		}
	}

	String judgeFemale(String socialNumber) {
		String gender = "";
		int genderDigit = Character.getNumericValue(socialNumber.charAt(6));
		if (genderDigit == 2 || genderDigit == 4) {
			gender = "woman";
			return gender;
		} else if (genderDigit == 1 || genderDigit == 3) {
			gender = "man";
		}
		return "";
	}

	int countNumber() throws Exception { // 개수 카운트
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n");
		int numberOfOrders = sc.nextInt();
		if (numberOfOrders > 10 || numberOfOrders < 0) {
			throw new Exception("주문 가능 개수는 1인당 1개에서 최대 10개 입니다.\n");
		}
		return numberOfOrders;
	}

	// 장애인 40%
	// 국가유공자 50%
	// 다자녀 20%
	// 임산부 15%
	double treatment() throws Exception { // 우대사항
		Scanner sc = new Scanner(System.in);
		int specificCase;
		double discount;

		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음 (나이 우대는 자동처리)\n"); // 65세 이상은 어린이 요금과 동일하게 처리
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");
		specificCase = sc.nextInt();
		if (specificCase < 1 || specificCase > 5) {
			throw new Exception("우대사항은 1번에서 5번 사이로 골라주세요");
		}

		switch (specificCase) {
		case 1:
			discount = 1; // 없음
			return discount;
		case 2:
			discount = 0.6; // 장애인
			return discount;
		case 3:
			discount = 0.5; // 국가유공자
			return discount;
		case 4:
			discount = 0.8; // 다자녀
			return discount;
		case 5:
			discount = 0.85; // 임산부
			return discount;
		}
		return 0;
	}

	int calculPrice(int selectTicket, String ageGroup, String gender) throws Exception { // 가격 계산
		int ticketNumbers, temporaryPrice = 0, finalPrice;
		double discountTicket;

		ticketNumbers = countNumber();
		discountTicket = treatment();

		if (discountTicket == 0.85) {
			if (!ageGroup.equals("성인") || !gender.equals("woman")) {
				throw new Exception("임산부 우대사항은 성인 여성에게만 적용됩니다.");
			}
		}

		switch (selectTicket) {
		case 1:
			switch (ageGroup) {
			case "노인":
				if (discountTicket == 1) {
					temporaryPrice = 46000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (46000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (46000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (46000 * discountTicket);
				}
				break;
			case "성인":
				if (discountTicket == 1) {
					temporaryPrice = 59000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (59000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (59000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (59000 * discountTicket);
				} else if (discountTicket == 0.85) {
					temporaryPrice = (int) (59000 * discountTicket);
				}
				break;
			case "청소년":
				if (discountTicket == 1) {
					temporaryPrice = 52000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (52000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (52000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (52000 * discountTicket);
				}
				break;
			case "어린이":
				if (discountTicket == 1) {
					temporaryPrice = 46000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (46000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (46000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (46000 * discountTicket);
				}
				break;
			case "베이비":
				if (discountTicket == 1) {
					temporaryPrice = 15000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (15000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (15000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (15000 * discountTicket);
				}
				break;
			}
			break;
		case 2:
			switch (ageGroup) {
			case "노인":
				if (discountTicket == 1) {
					temporaryPrice = 35000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (35000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (35000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (35000 * discountTicket);
				}
				break;
			case "성인":
				if (discountTicket == 1) {
					temporaryPrice = 47000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (47000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (47000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (47000 * discountTicket);
				} else if (discountTicket == 0.85) {
					temporaryPrice = (int) (47000 * discountTicket);
				}
				break;
			case "청소년":
				if (discountTicket == 1) {
					temporaryPrice = 41000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (41000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (41000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (41000 * discountTicket);
				}
				break;
			case "어린이":
				if (discountTicket == 1) {
					temporaryPrice = 35000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (35000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (35000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (35000 * discountTicket);
				}
				break;
			case "베이비":
				if (discountTicket == 1) {
					temporaryPrice = 15000;
				} else if (discountTicket == 0.6) {
					temporaryPrice = (int) (15000 * discountTicket);
				} else if (discountTicket == 0.5) {
					temporaryPrice = (int) (15000 * discountTicket);
				} else if (discountTicket == 0.8) {
					temporaryPrice = (int) (15000 * discountTicket);
				}
				break;
			}
			break;
		}
		finalPrice = temporaryPrice * ticketNumbers;
		return finalPrice;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LotteWorld lw = new LotteWorld();

		int selectContinue, price;

		while (true) {
			price = lw.choiceDayNight();
			System.out.println("가격은 " + price + "원 입니다.");
			System.out.printf("\n계속 발권 하시겠습니까?\n");
			System.out.printf("1. 티켓 발권\n");
			System.out.printf("2. 종료\n");
			selectContinue = sc.nextInt();
			if (selectContinue == 2) {
				System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
				break;
			} else if (selectContinue == 1) {
				continue;
			} else {
				throw new Exception("error");
			}
		}
	}

}