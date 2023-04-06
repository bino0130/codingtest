package codingtest;

import java.util.*;

/*
 * 모든 학생의 착생에 바구니 A, B, C 존재

	A 사과, B 배, C 귤

	자기 책상에 있는 과일 바구니 중 개수가 가장 적게
	들어있는 바구니 선택 가능

   *자기 바구니의 과일 한 개를 다른 학생과 교환할 수
	있는 기회 1번 있음

	조건 1. 1번부터 차례대로 교환 가능 (ex 1번 교환 끝 -> 2번 교환)
	조건 2. 과일 교환 시 서로 이득이라면(과일 개수가 증가한다면) 무조건 교환)
	조건 3. 교환 시 A에는 사과만, B에는 배만, C에는 귤만 담을 수 있음
	조건 4. 교환 가능한 사람이 여러명일 경우 가장 번호가 작은 학생과 교환
	조건 5. 서로가 이득이 안된다면 교환하지 않아도 됨

	1번 학생부터 마지막 학생까지 교환이 모두 끝나고 나면
	학생들이 가져가는 토탈 과일 개수 'fruit' 반환
 */

class Solution3 {
	public int solution(int[][] fruit) {
		int answer = 0;
		

		return answer;
	}
	
	public int minResult (int[][] fruit) {
		
		for (int[] array : fruit) {
			// 최소값, 최소값 인덱스 초기화
			int min = array[0];
			int minIndex = 0;
			
			// 최소값 , 최소값 인덱스 구하기
			for (int i = 0; i < array.length; i++) {
				if(array[i] < min) {
					min = array[i];
					minIndex = i;
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		System.out.println(T.solution(
				new int[][] { { 10, 20, 30 }, { 12, 15, 20 }, { 20, 12, 15 }, { 15, 20, 10 }, { 10, 15, 10 } }));
		System.out.println(T.solution(new int[][] { { 10, 9, 11 }, { 15, 20, 25 } }));
		System.out.println(T.solution(
				new int[][] { { 0, 3, 27 }, { 20, 5, 5 }, { 19, 5, 6 }, { 10, 10, 10 }, { 15, 10, 5 }, { 3, 7, 20 } }));
		System.out.println(T.solution(new int[][] { { 3, 7, 20 }, { 10, 15, 5 }, { 19, 5, 6 }, { 10, 10, 10 },
				{ 15, 10, 5 }, { 3, 7, 20 }, { 12, 12, 6 }, { 10, 20, 0 }, { 5, 10, 15 } }));
	}
}