package another;

import java.util.Arrays;

// 접근 방식 : String을 입력 받고
// Contains를 써서 String이 " a " 또는 " an "을 포함하고 있는지 확인
// " a ", " a " 를 기준으로 앞 뒤를 자름
// " a "뒤 첫 음이 Vowel (a,e,i,o,u)가 온다면 a를 an으로 변경 (== 사용)
// " a "뒤 첫 음이 Consonant가 온다면 a 변경 X (!= 사용)

import java.util.Scanner;

public class P14 {
	public Scanner sc = new Scanner(System.in);
	public String text = sc.nextLine();

	public static void main(String[] args) {
		P14 call = new P14();
		call.spellChecker();
	}

	private void spellChecker() {

//		String changedText = text.replace(" a ", " an ");
//		System.out.println(changedText);

		if (text.contains(" a ")) { // 문장에 관사 a가 들어갈 경우
			aChecker();
		} else if (text.contains(" an ")) { // 문장에 관사 an이 들어갈 경우
			anChecker();
		}
	}

	private void aChecker() {
		String[] str = text.split(" a ");
		String res = str[1];
		
		if (res.charAt(0) == 'a' || res.charAt(0) == 'e' || res.charAt(0) == 'i' || res.charAt(0) == 'o' || res.charAt(0) == 'u') {
			String changedText = text.replace(" a ", " an ");
			System.out.println(changedText);
		} 
		else if (res.charAt(0) != 'a' && res.charAt(0) != 'e' && res.charAt(0) != 'i' && res.charAt(0) != 'o' && res.charAt(0) != 'u') {
			System.out.println(text);
		}
	}

	private void anChecker() {
		String[] str = text.split(" an ");
		String res = str[1];
		
		if (res.charAt(0) == 'a' || res.charAt(0) == 'e' || res.charAt(0) == 'i' || res.charAt(0) == 'o' || res.charAt(0) == 'u') {
			System.out.println(text);
		} 
		else if (res.charAt(0) != 'a' && res.charAt(0) != 'e' && res.charAt(0) != 'i' && res.charAt(0) != 'o' && res.charAt(0) != 'u') {
			String changedText = text.replace(" an ", " a ");
			System.out.println(changedText);
		}
	}

}