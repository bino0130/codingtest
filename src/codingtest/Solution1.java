package codingtest;

import java.util.*;
//class Solution1 {
//	public int[] solution(int c, int r, int k){
//		int[][] doubleArray = new int[c][r];
//		for (int[] array : doubleArray) {
//			
//		}
//		
//		int[] answer = new int[2];
//		int cnt = 0;
//		int n = doubleArray.length;
//		int[] dx = {0, 1, 0, -1};
//		int[] dy = {1, 0, -1, 0};
//		int d = 1, x = 0, y = 0;
//		while (cnt < k) {
//			cnt++;
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//			if(nx < 0 || ny < 0 || nx >= c || ny >= r) {
//				d = (d + 1) % 4;
//				continue;
//			}
//			x = nx;
//			y = ny;
//		}
//		answer[0] = x;
//		answer[1] = y;
//		
//		return answer;
//	}
//
//	public static void main(String[] args){
//		Solution1 T = new Solution1();
//		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
//		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
//	}
//}

// 1일차 사다리타기
//class Solution1 {
//	public char[] solution(int n, int[][] ladder) { // get 2 parameter
//		char[] answer = new char[n];
//
//		for (int i = 0; i < n; i++) {
//			answer[i] = (char) (i + 65); // answer에 알파벳 출력하는 반복문
//		}
//
//		for (int[] line : ladder) { // int 배열 line에 ladder 하나씩 넣기
//			for (int x : line) { // int x에 line 하나씩 넣기
//				char tmp = answer[x]; // tmp는 answer의 x번째 인덱스
//				answer[x] = answer[x - 1]; // answer[x]는 answer [x-1]
//				answer[x - 1] = tmp; // answer[x-1]는 tmp
//			}
//		}
//		
//		return answer;
//	}
//
//	public static void main(String[] args) {
//		Solution1 T = new Solution1();
//		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
//		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
//		System.out.println(
//				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
//		System.out.println(Arrays.toString(T.solution(12,
//				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
//	}
//}

// 3일차 압축해제
// Stack 사용하기
class Solution1 {
	public String solution(String s){
		String answer = "";
		Stack<String> st = new Stack<>();
		String[] splitS = s.split("");
		List<String> addString = new ArrayList();
		
		for (int i = 0; i < splitS.length; i++) {
			if(!splitS[i].equals(")")) {
				st.push(splitS[i]);
			} else {
				int j = 0;
				while(j < st.size()) {
					String output = st.peek();
					if (!output.equals("(")) { // stack의 맨 위가 (가 아니라면 
						addString.add(output); // addString에 추가
						st.pop(); // 맨 위 제거
					} else {
						
						st.pop();
					}
					
				}
				
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}