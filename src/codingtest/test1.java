package codingtest;

import java.util.Scanner;

public class test1 {
///*
// * 커피 : 2000원
// * 알바 분급 : 167원
// * 커피 1잔 소요시간 : 3분
// * 수익률 : 0.66
// * 10잔 사면 1잔 공짜
// * 
// * input으로 x잔 입력하면
// * output으로 지불금액, 순수익, 무료커피 몇잔 제공 출력
// */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int coffeePrice = 2000;
//		int albaPrice = 167;
//		int makingtime = 3;
//		double revenue = 0.66;
//		System.out.println("커피 몇 잔을 구매하실 건가요?");
//		int input = sc.nextInt();
//		int freeCoffee = input / 10;
//		int totalPrice = (coffeePrice * input) - (freeCoffee * coffeePrice); 
////		double benefit = (totalPrice - (albaPrice * makingtime)) * revenue;
//		double benefit = (totalPrice * revenue) - (albaPrice * makingtime);
//			
//		if (input < 10) {
//			System.out.println(totalPrice + "원"); // 지불금액
//			System.out.println(benefit + "원"); // 순수익
//		} else if(input > 9) {
//			benefit = (totalPrice * revenue) - (albaPrice * makingtime) - (freeCoffee * coffeePrice);
//			System.out.println(totalPrice + "원"); // 지불금액
//			System.out.println(benefit + "원"); // 순수익
//			System.out.println("무료커피" + freeCoffee + "잔");
//		}
//	}
//


//	public static void main(String[] args) {
//		int n = 10;
//		
//		for (int i = 0; i < n; i++) {
//			System.out.print(Fibonacci(i) + " ");
//		}
//	}
//	
//	public static int Fibonacci(int n) {
//		if(n == 0) {
//			return 0;
//		} 
//		if (n == 1 || n == 2) {
//			return 1;
//		} else {
//			return Fibonacci(n - 1) + Fibonacci(n - 2);
//		}
//	}

	
	public int solution(String s){
		int answer = 0;
		
		
		
		return answer;
	}
		
	public static void main(String[] args){
		test1 T = new test1();
		System.out.println(T.solution("25114"));
		System.out.println(T.solution("23251232"));
		System.out.println(T.solution("21020132"));
		System.out.println(T.solution("21350"));
		System.out.println(T.solution("120225"));
		System.out.println(T.solution("232012521"));
	}
}
	
//package codingtest;
//
//import java.util.*;
//
//public class test1{
//	
//	static int[] pm, ch, arr;
//	static int n, m;
//	public void DFS(int L) {
//		if(L == m) {
//			for (int x : pm) {
//				System.out.print(x + " ");
//				System.out.println();
//			}
//		}else {
//			for (int i = 0; i < n; i++) {
//				if(ch[i] == 0) {
//					ch[i] = 1;
//					pm[L] = arr[i];
//					DFS(L + 1);
//					ch[i] = 0;
//				}
//			}
//		}
//	}
//		
//	public static void main(String[] args) {
//			test1 T = new test1();
//			Scanner sc = new Scanner(System.in);
//			n = sc.nextInt();
//			m = sc.nextInt();
//			arr = new int[n];
//			for(int i = 0; i < n; i++) {
//				arr[i] = sc.nextInt();
//			}
//			ch = new int[n];
//			pm = new int[m];
//			T.DFS(0);
//	}
//}