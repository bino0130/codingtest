package codingtest;

import java.util.*;

// 중복제거 해줘야함, 사람이름은 소문자로만 구성
// 특정 시간의 범위를 parameter로 받으면 그 시간 범위 안에 접속한 사람들을
// 배열에 담아 반환해야함
// Parsing으로 분단위로 바꿔야함 ex) 15:23 -> 15*60 + 23 -> 900 + 23 = 923
// Parsing된 시간으로 비교를 해서 나눠야할듯?
// times도 parsing해줘야함
class Info implements Comparable<Info> {
	public String name;
	public int time;
	Info(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public int compareTo(Info o) {
		return this.time - o.time;
	}
}

class Solution implements Comparable<Solution> {
	
	public String[] solution(String[] reports, String times) {
		String[] answer = {};
		List<String> firstSplit = new ArrayList<String>();
		List<String> secondSplit = new ArrayList<String>();
		
		HashMap<String, String> firstSplitMap = new HashMap<String, String>();
		
		// 1. 우선 반복문 돌려서 split해주기
		for (String a : reports) {
			String[] split = a.split(" ");
			String time = split[1];
			firstSplit.add(times);
		}
		
		// 2. 반복문 돌려서 넣은 시간 숫자로 치환
		// ':' 기준으로 나눠서 두개 각각 숫자로 치환해서 앞에 *60한 뒤 더해보자
		for (int i = 0; i < firstSplit.size(); i++) {
			firstSplit.get(i).replace(":", "");
		}
		
		return answer;
	}
	
	@Override
	public int compareTo(Solution o) {
		return 0;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(
				T.solution(new String[] { "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" },
						"08:33 09:45")));
		System.out
				.println(
						Arrays.toString(
								T.solution(
										new String[] { "ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57",
												"bill 17:35", "tom 07:23", "john 15:23", "park 09:59" },
										"15:01 19:59")));
		System.out.println(Arrays.toString(
				T.solution(new String[] { "cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50" },
						"14:20 15:20")));
	}
}