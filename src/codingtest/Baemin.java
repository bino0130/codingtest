package codingtest;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. 책을 임의로 펼친다 (범위는 1부터 400까지)
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 구한다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다. 
 */
public class Baemin {
	public static int pobiFinal, crongFinal;
	
	public static int randomSplit() {
		List<Integer> pobi = new ArrayList<Integer>();
		List<Integer> pobiInteger1 = new ArrayList<Integer>();
		List<Integer> pobiInteger2 = new ArrayList<Integer>();
		List<Integer> crong = new ArrayList<Integer>();
		List<Integer> crongInteger1 = new ArrayList<Integer>();
		List<Integer> crongInteger2 = new ArrayList<Integer>();
		int pobiAddLeft = 0, pobiMulLeft = 1, pobiLeft, pobiAddRight = 0, pobiMulRight = 1, pobiRight, 
				crongAddLeft = 0, crongMulLeft = 1, crongLeft, crongAddRight = 0, crongMulRight = 1, crongRight,
				 p1, p2, c1, c2;
		//////////////////////////////////////////////////////////
		p1 = (int) (Math.random() * 400) + 1;
		if (p1 == 1 || p1 == 2 || p1 == 399 || p1 == 400) {
			p1 = (int) (Math.random() * 400) + 1;
		} else if (p1 == 0){
			return -1;
		} else {
			p1 = p1;
		}
		
		p2 = p1 + 1;
		
		c1 = (int) (Math.random() * 400) + 1;
		if (c1 == 1 || c1 == 2 || c1 == 399 || c1 == 400) {
			c1 = (int) (Math.random() * 400) + 1;
		} else if (c1 == 0) {
			return -1;
		} else {
			c1 = c1;
		}
		
		c2 = c1 + 1;
		////////////////////////////////////////////////////////////
		pobi.add(p1); // 포비 첫번째 값
		pobi.add(p2); // 포비 두번째 값
		System.out.print("pobi : {");
		for(int i = 0; i < pobi.size(); i++) {
			if (i == pobi.size() - 1) {
				System.out.print(pobi.get(i));
			} else {
				System.out.print(pobi.get(i) + ",");
			}
		}
		System.out.println("}");
		////////////////////////////////////////////////////////////
		crong.add(c1); // 크롱 첫번째 값
		crong.add(c2); // 크롱 두번째 값
		System.out.print("crong : {");
		for(int i = 0; i < crong.size(); i++) {
			if (i == crong.size() - 1) {
				System.out.print(crong.get(i));
			} else {
				System.out.print(crong.get(i) + ",");
			}
		}
		System.out.println("}");
		

		String pobi1 = String.valueOf(pobi.get(0)); // 포비 첫번째 값 문자열로 변경
		String pobi2 = String.valueOf(pobi.get(1)); // 포비 두번째 값 문자열로 변경

		String crong1 = String.valueOf(crong.get(0)); // 크롱 첫번째 값 문자열로 변경
		String crong2 = String.valueOf(crong.get(1)); // 크롱 두번째 값 문자열로 변경

		String[] splitPobi1 = pobi1.split(""); // 포비 첫번째 값 하나씩 쪼개기
		String[] splitPobi2 = pobi2.split(""); // 포비 두번째 값 하나씩 쪼개기

		String[] splitCrong1 = crong1.split(""); // 크롱 첫번째 값 하나씩 쪼개기
		String[] splitCrong2 = crong2.split(""); // 크롱 두번째 값 하나씩 쪼개기

		for (int i = 0; i < splitPobi1.length; i++) {
			pobiInteger1.add(Integer.parseInt(splitPobi1[i])); // 하나씩 쪼갠 포비 첫번째 값 다시 정수형으로 변환해서 리스트에 넣기
		}
		for (int i = 0; i < splitPobi2.length; i++) {
			pobiInteger2.add(Integer.parseInt(splitPobi2[i])); // 하나씩 쪼갠 포비 두번째 값 다시 정수형으로 변환해서 리스트에 넣기
		}

		for (int i = 0; i < splitCrong1.length; i++) {
			crongInteger1.add(Integer.parseInt(splitCrong1[i])); // 하나씩 쪼갠 크롱 첫번째 값 다시 정수형으로 변환해서 리스트에 넣기
		}
		for (int i = 0; i < splitCrong2.length; i++) {
			crongInteger2.add(Integer.parseInt(splitCrong2[i])); // 하나씩 쪼갠 크롱 두번째 값 다시 정수형으로 변환해서 리스트에 넣기
		}

		for (int i = 0; i < pobiInteger1.size(); i++) {
			pobiAddLeft += pobiInteger1.get(i); // pobiAddLeft 값 구하기
			pobiMulLeft *= pobiInteger1.get(i); // pobiMulLeft 값 구하기
		}
		
		for (int i = 0; i < pobiInteger2.size(); i++) {
			pobiAddRight += pobiInteger2.get(i); // pobiAddRight 값 구하기
			pobiMulRight *= pobiInteger2.get(i); // pobiMulRight 값 구하기
		}

		pobiLeft = Math.max(pobiAddLeft, pobiMulLeft); // 포비 왼쪽값 크기 비교
		pobiRight = Math.max(pobiAddRight, pobiMulRight); // 포비 오른쪽값 크기 비교
		pobiFinal = Math.max(pobiLeft, pobiRight); // pobiFinal 값 구하기
		
		System.out.println("pobiFinal : " + pobiFinal);

		for (int i = 0; i < crongInteger1.size(); i++) {
			crongAddLeft += crongInteger1.get(i); // crongAddLeft 값 구하기
			crongMulLeft *= crongInteger1.get(i); // crongMulLeft 값 구하기
		}
		
		for (int i = 0; i < crongInteger2.size(); i++) {
			crongAddRight += crongInteger2.get(i); // crongAddRight 값 구하기
			crongMulRight *= crongInteger2.get(i); // crongMulRight 값 구하기
		}

		crongLeft = Math.max(crongAddLeft, crongMulLeft); // 크롱 왼쪽값 크기 비교
		crongRight = Math.max(crongAddRight, crongMulRight); // 크롱 오른쪽값 크기 비교
		crongFinal = Math.max(crongLeft, crongRight); // crongFinal 값 구하기
		
		System.out.println("crongFinal : " + crongFinal);
		int answer = solution(pobiFinal, crongFinal); 
		return answer;
	}

	public static int solution(int pobiFinal, int crongFinal) {
		int answer = 0;
		if (pobiFinal > crongFinal) {
			answer = 1;
			System.out.println("포비 승리! " );
			return 1;
		} else if (crongFinal > pobiFinal) {
			answer = 2;
			System.out.println("크롱 승리! " );
			return 2;
		} else {
			answer = 0;
			System.out.println("무승부! " );
			return 0;
		}
//		return answer;
	}

	public static void main(String[] args) {
		randomSplit();
//		solution(pobiFinal, crongFinal);
	}

}
