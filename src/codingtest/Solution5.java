package codingtest;

import java.util.*;
import java.util.Map.Entry;

class Solution5 {
	
	public String solution(String[] votes, int k) {
		HashMap<String, Integer> votermap = new HashMap<>();
		HashMap<String, Integer> votedmap = new HashMap<>();
		List<String> votedname = new ArrayList<String>();
		List<String> maxkey = new ArrayList<String>();
		String answer = " ";
		
		for (int i = 0; i < votes.length; i++) {
			String[] splitString = votes[i].split(" ");
			String vote = splitString[0];
			String voted = splitString[1];
			
			votedmap.put(voted, votedmap.getOrDefault(voted, 0) + 1); // 사람별로 투표받은 횟수 카운트
		}

		// 그 다음은 ? -> k번 이상 투표받은 사람 걸러내기
		for (String key : votedmap.keySet()) { // votedmap에서 key값 하나씩 가져오기
			if (votedmap.get(key) > 1) { // 만약 n번째 key의 value값이 2 이상이라면 그 key를 따로 빼내야함
				votedname.add(key); // k번 이상 투표받은 사람 리스트에 저장
			}
		}
		
		// k번 이상 투표받은 사람들 저장했으면?
		// 그 다음에는 그 사람들을 투표한 사람들을 찾아야함
		for (int i = 0; i < votes.length; i++) {
			String[] splitString = votes[i].split(" ");
			String voter = splitString[0];
			String voted = splitString[1];
			for (int j = 0; j < votedname.size(); j++) { 
				if (voted.equals(votedname.get(j))) { // voted가 votedname의 j번째 값과 같다면
					votermap.put(voter, votermap.getOrDefault(voter, 0) + 1); // 투표한 사람(= 선물받을 사람) 카운트
				}
			}
		}
		
		// 사람별로 선물받을 횟수 카운트 다 하고나면? -> value 최대값 구하고 최대값 가지고 있는 key들 찾기
		// 1. value 최대값 구하기
		int maxValue = 0;
		for (String key : votermap.keySet()) {
			if (maxValue == 0 || maxValue < votermap.get(key)) {
				maxValue = votermap.get(key);
			}
		}
//		maxValue = maxValue;
		
		// 2. maxValue 가지고 있는 key 찾기
		for (String key : votermap.keySet()) { // votermap에서 key값 하나씩 가져오기
			if (votermap.get(key) == maxValue) { // 만약 n번째 key의 value값이 maxValue와 같다면
				maxkey.add(key); // maxkey 리스트에 저장
			}
		}
		
		// 3. 리스트 정렬하기
		Collections.sort(maxkey);
		answer = maxkey.get(0);
		
		return answer; // 리스트 1번째 값 리턴
	}
	

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
				"luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}