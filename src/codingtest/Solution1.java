package codingtest;

import java.util.*;
class Solution1 {
	public int[] solution(int c, int r, int k){
		int[][] doubleArray = new int[c][r];
//		for (int[] array : doubleArray) {
//			
//		}
		
		int[] answer = new int[2];
		int cnt = 0;
		int n = doubleArray.length;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int d = 1, x = 0, y = 0;
		while (cnt < k) {
			cnt++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || ny < 0 || nx >= c || ny >= r) {
				d = (d + 1) % 4;
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}