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

class Solution2 {
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2];
		int n = board.length;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int x = 0, y = 0, d = 1, cnt = 0;
		
		while (cnt < k) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
				d = (d + 1) % 4;
				cnt++;
				continue;
			}
			
			x = nx;
			y = ny;
			answer[0] = x;
			answer[1] = y;
			cnt++;
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
	}
}