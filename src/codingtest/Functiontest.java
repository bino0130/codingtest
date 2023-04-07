package codingtest;

import java.util.HashMap;

public class Functiontest {

	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		hm.put("apple", 1500);
		hm.put("banana", 3500);
		hm.put("melon", 5000);
		
		System.out.println(hm.values());
	}

}