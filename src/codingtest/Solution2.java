package codingtest;

import java.util.*;

// 배열 마지막 인덱스 = length - 1
// 배열에서 peak값들을 먼저 찾아야함
class Solution2 {
	public int solution(int[] nums) {
		int answer = 0;
		ArrayList<Integer> peaks = new ArrayList<>();
		
		
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}
		
		for (int x : peaks) {
			int left = x;
			int right = x;
			int cnt = 1;
			// left의 값이 0보다 크거나 같고, nums[left - 1]이 nums[left]보다 작다면
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				
			}
		}

		
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}