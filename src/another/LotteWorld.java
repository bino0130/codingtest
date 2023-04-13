package another;

import java.util.Scanner;
//롯데월드 매표소
//권종을 입력받는다. (주간권, 야간권)
//주민등록번호를 입력 받는다. (주민번호를 활용하여 나이를 자동계산한다.)
//주문 개수를 입력받는다.
//우대사항을 입력받는다. (없음, 장애인, 국가유공자, 다자녀, 임산부)
//위의 입력을 반복할 것인지 종료할 것인지 물어본다.
//종료를 하게되면 지금까지 주문 내역이 모두 출력된다.
//완전 프로그램 종료를 하게 되면 현재까지의 매출 내역을 파일로 저장한다

public class LotteWorld {
	public static int inputSocialNumber() { // 주민등록번호 입력 후 나이계산
		int birthYear = 0, birthMonth, birthDay, age;
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("주민번호를 입력하세요\n");
		String socialNumber = sc.nextLine(); // 123456-1234567에서 '-' 빼고 입력
	    
		if (socialNumber.length() == 13) {
			int yearPreFix = Integer.parseInt(socialNumber.substring(0, 2));
			int genderDigit = Character.getNumericValue(socialNumber.charAt(6));
			if (genderDigit == 1 || genderDigit == 2) {
				birthYear = 1900 + yearPreFix;
			} else {
				birthYear = 2000 + yearPreFix;
			}
		}
		
		age = 2023 - birthYear + 1;
		
		System.out.printf("나이 : %d살\n", age);
		return age;
	} 

	public static int choiceNumber() { // 권종 선택 
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("권종을 선택하세요.\n") ;
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		int selectTicket = sc.nextInt();
		System.out.printf("%d\n", selectTicket);
		
		return selectTicket;
	}

	public static void dayNight() { // 주간권 or 야간권 
		int adultPrice, teenPrice, kidsPrice, babyPrice, adultNightPrice, 
		teenNightPrice, kidsNightPrice, babyNightPrice;
		
		int result = choiceNumber(); // choiceNumber 호출 
		if(result == 1) {
			adultPrice = 59000;
			teenPrice = 52000;
			kidsPrice = 46000;
			babyPrice = 15000;
		} else if (result == 2) {
			adultNightPrice = 47000;
			teenNightPrice = 41000;
			kidsNightPrice = 35000;
			babyNightPrice = 15000;
		} else {
			System.out.printf("잘못 입력하셨습니다.");
		}
	}

	public static int countNumber() { // 개수 카운트
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n");
		int numberOfOrders = sc.nextInt();
	    if (numberOfOrders > 10) {
	    	System.out.printf("주문 가능 개수는 1인당 최대  10개 입니다.\n");
		}
		
		return numberOfOrders;
	} 
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int specificCase, price, selectContinue;

		while(true) {
		///////////////////////////////////////// 권종 선택 
		
		///////////////////////////////////////// 주민등록번호 입력 후 나이계산 
		inputSocialNumber();
	    
	    ///////////////////////////////////////// 개수 카운트 
	    countNumber();
	    
	    ///////////////////////////////////////// 우대사항 & 가격계산 
	    // 장애인 40%
		// 국가유공자 50%
		// 다자녀 20%
		// 임산부 15%
		// 주간 : 어른 59 , 청소년 52, 어린이 46, 유아 15 
		// 야간 : 어른 47 , 청소년 41, 어린이 35, 유아 15 
	    System.out.printf("우대사항을 선택하세요.\n");
	    System.out.printf("1. 없음 (나이 우대는 자동처리)\n"); // 65세 이상은 어린이 요금과 동일하게 처리 
	    System.out.printf("2. 장애인\n");
	    System.out.printf("3. 국가유공자\n");
	    System.out.printf("4. 다자녀\n");
	    System.out.printf("5. 임산부\n");
	    specificCase = sc.nextInt();
	    
	    
		
	   System.out.printf("계속 발권 하시겠습니까?\n");
	   System.out.printf("1. 티켓 발권\n");
	   System.out.printf("2. 종료\n");
	   selectContinue = sc.nextInt();
	   if (selectContinue == 2) {
		   System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
			break;   		
	   } else if (selectContinue == 1){
	   		continue;
	   } 
	 }
	}

}
