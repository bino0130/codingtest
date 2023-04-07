package codingtest;

import java.util.*;

//1. 첫번째 인덱스부터 자기 앞에 있는 인덱스 값을 1개, 2개씩 더함
//2. 더했을 때 나오는 값을 따로 선언해 둔 map 변수에다가 저장함
//3. 첫번째 인덱스부터 마지막 인덱스까지 계산을 하면 2번째 인덱스로 넘어감
//
//class Solution4 {
//	public int solution(int[] nums, int m) {
//		
//		int answer = 0, cnt = 0, sum = 0;
//		
//		for(int i = 0; i < nums.length; i++) {
//			sum = sum + nums[i];
//			
//			if (sum == m) {
//				cnt++;
//			}
//			
//		}
//
//		return answer;
//	}
//
//	public static void main(String[] args) {
//		Solution4 T = new Solution4();
//		System.out.println(T.solution(new int[] { 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2 }, 3));
//		System.out.println(T.solution(new int[] { -1, 0, 1 }, 0));
//		System.out.println(T.solution(new int[] { -1, -1, -1, 1 }, 0));
//	}
//}

// 3일차 문제 4
// 힌트 1 이 수열의 최소값은 무조건 선생님이 작성한 수열의 값이다
// 힌트 2 이 배열을 오름차순으로 정렬해보자
class Solution4 {
	public List solution(int[] nums) {
		List<Integer> wholeList = new ArrayList<Integer>();

		for (int x : nums) {
			wholeList.add(x);
		}

		Collections.sort(wholeList);

		for (int i = 0; i < wholeList.size(); i++) {
			for (int j = 0; j < wholeList.size(); j++) {
				if (wholeList.get(i) * 2 == wholeList.get(j)) {
					wholeList.remove(j);
				}
			}
		}

		return wholeList;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(T.solution(new int[] { 1, 10, 2, 3, 5, 6 }));
		System.out.println(T.solution(new int[] { 1, 1, 6, 2, 2, 7, 3, 14 }));
		System.out.println(T.solution(new int[] { 14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14 }));
	}
}