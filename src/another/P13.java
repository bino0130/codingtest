package another;
import java.util.ArrayList;
import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String word = sc.nextLine();
		int count = 0;
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == (char)'c' || word.charAt(i) == (char)'o'){
				list.add(word.substring(i, i + 1));
			} else if (word.charAt(i) == (char)'l') {
				list.add(word.substring(i, i + 1));
			}
		}
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("c")) {
				if (list.get(i + 1).equals("o") && list.get(i + 2).equals("o") && list.get(i + 3).equals("l")) {
				}
				count++;
			}
		}

		System.out.println(count);
	}

}
