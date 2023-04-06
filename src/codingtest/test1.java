package codingtest;

import java.util.Scanner;

public class test1 {
/*
 * 커피 : 2000원
 * 알바 분급 : 167원
 * 커피 1잔 소요시간 : 3분
 * 수익률 : 0.66
 * 10잔 사면 1잔 공짜
 * 
 * input으로 x잔 입력하면
 * output으로 지불금액, 순수익, 무료커피 몇잔 제공 출력
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coffeePrice = 2000;
		int albaPrice = 167;
		int makingtime = 3;
		double revenue = 0.66;
		System.out.println("커피 몇 잔을 구매하실 건가요?");
		int input = sc.nextInt();
		int freeCoffee = input / 10;
		int totalPrice = (coffeePrice * input) - (freeCoffee * coffeePrice); 
//		double benefit = (totalPrice - (albaPrice * makingtime)) * revenue;
		double benefit = (totalPrice * revenue) - (albaPrice * makingtime);
			
		if (input < 10) {
			System.out.println(totalPrice + "원"); // 지불금액
			System.out.println(benefit + "원"); // 순수익
		} else if(input > 9) {
			benefit = (totalPrice * revenue) - (albaPrice * makingtime) - (freeCoffee * coffeePrice);
			System.out.println(totalPrice + "원"); // 지불금액
			System.out.println(benefit + "원"); // 순수익
			System.out.println("무료커피" + freeCoffee + "잔");
		}
	}

}