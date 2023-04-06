package another;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class A6 {
	static ArrayList<Integer> list = new ArrayList<Integer>(); // 필드 ArrayList 선언
	
    public static void main(String[] args) {
    	A6 cal = new A6();
    	
    	try {
    		int input = cal.input();
    		if (input < 1) { // 1 미만의 숫자를 입력했을 때 Exception 발생시킴
    			System.out.println("숫자는 1부터 입력 가능합니다.");
    			throw new Exception();
    		}
    		cal.fibonacci(input);
    		cal.printList();
    	} catch (InputMismatchException e) {
    		System.out.println("InputMismatchException Error");
    	} catch (Exception e) {
    		
    	}
    }
    
    public int input() { // 스캐너 입력
    	Scanner sc = new Scanner(System.in);
    	System.out.println("숫자 입력!");
    	return sc.nextInt();
    }
    
    public void fibonacci(int input) { // 피보나치 수열 생성 후 리스트에 저장
    	int F0 = 0;
    	int F1 = 1;
    	int i = 0;
    	while (i < input - 2) {
    		int F2 = F0 + F1;
    		F0 = F1;
    		F1 = F2;
    		i++;
    		list.add(F2);
    	}
    }
    
    public void printList () { // 수열 출력
    	System.out.print("0 1 ");
    	for (int i = 0; i < list.size(); i++) {
    		System.out.print(list.get(i) + " ");
    	}
    }
}