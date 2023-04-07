package codingtest;

import java.util.*;

// 배열 마지막 인덱스 = length - 1
// 배열에서 peak값들을 먼저 찾아야함
//
//class Solution2 {
//	public int solution(int[] nums) {
//		int answer = 0;
//		ArrayList<Integer> peaks = new ArrayList<>();
//		
//		for (int i = 1; i < nums.length - 1; i++) {
//			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
//				peaks.add(i);
//			}
//		}
//		
//		for (int x : peaks) {
//			int left = x;
//			int right = x;
//			int cnt = 1;
//			// left의 값이 0보다 크거나 같고, nums[left - 1]이 nums[left]보다 작다면
//			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
//				
//			}
//		}
//
//		return answer;
//	}
//
//	public static void main(String[] args) {
//		Solution2 T = new Solution2();
//		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
//		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
//		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
//		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
//	}
//}

//class Solution2 {
//	public int[] solution(int[][] board, int k){
//		int[] answer = new int[2];
//		int n = board.length;
//		
//		int[] dx = {0, 1, 0, -1};
//		int[] dy = {1, 0, -1, 0};
//		
//		int x = 0, y = 0, d = 1, cnt = 0;
//		
//		while (cnt < k) {
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//			
//			if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
//				d = (d + 1) % 4;
//				cnt++;
//				continue;
//			}
//			
//			x = nx;
//			y = ny;
//			answer[0] = x;
//			answer[1] = y;
//			cnt++;
//		}
//		
//		return answer;
//	}
//
//	public static void main(String[] args){
//		Solution2 T = new Solution2();
//		int[][] arr1 = {{0, 0, 0, 0, 0}, 
//			{0, 1, 1, 0, 0}, 
//			{0, 0, 0, 0, 0}, 
//			{1, 0, 1, 0, 1}, 
//			{0, 0, 0, 0, 0}};
//		System.out.println(Arrays.toString(T.solution(arr1, 10)));
//		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
//			{0, 0, 0, 0, 0, 0}, 
//			{0, 0, 0, 0, 0, 1}, 
//			{1, 1, 0, 0, 1, 0}, 
//			{0, 0, 0, 0, 0, 0},
//			{0, 0, 0, 0, 0, 0}};
//		System.out.println(Arrays.toString(T.solution(arr2, 20)));
//		int[][] arr3 = {{0, 0, 1, 0, 0}, 
//			{0, 1, 0, 0, 0}, 
//			{0, 0, 0, 0, 0}, 
//			{1, 0, 0, 0, 1}, 
//			{0, 0, 0, 0, 0}};
//		System.out.println(Arrays.toString(T.solution(arr3, 25)));
//	}
//}

// 3일차 2번
class Solution2 {
	public int solution(int[] keypad, String password){
		int answer = 0;
		int[][] array = new int[3][3];
		
		// 1차원 배열 keypad를 2차원 배열 array로 변환하기
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = keypad[j + i*3];
			}
		}
		
		// 이웃한 번호 -> i나 j끼리 뺏을 때 값이 1 이하인 번호
		// 이웃하지 않은 번호 -> i나 j끼리 뺏을 때 값이 2이상인 번호
		// parameter로 받은 String password의 번호 순서대로 이동해야함
		// 출발지점은 parameter의 첫번째 값
		
		// 우선 password를 하나씩 쪼개보자
		String[] pwArray = {};
		for (int i = 0; i < password.length(); i++) {
			pwArray = password.split("");
		}
		
		// 하나씩 쪼갠 password을 String에서 int로 형변환해주자
		ArrayList<Integer> intArray = new ArrayList<Integer>(); 
		for (int i = 0; i < pwArray.length; i++) {
			intArray.add(Integer.parseInt(pwArray[i])); //intArray에 integer로 형변환한 pw 하나씩 넣어주기
		}
		
		// intArray 값 하나씩 넣어주면서 2차원배열 array에서 해당 값 찾기
		int cnt = 0, x = 0, y = 0;

		for (int i = 0; i < array.length; i++) {
			int[] row = array[i];
			for (int j = 0; j < row.length; j++) {
				if(array[i][j] == intArray.get(i)) {
					
				}
			}
		}
		
		int i = 0, j = 0;
		while(i < array.length) {
			int[] row = array[i];
			while(j < row.length) {
				
			}
		}
		
		return answer;
	}
	
	public int[] findIndex(ArrayList<Integer> intArray, int[][] array) {
		int[] ss = {};
		
		
		
		return ss;
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}