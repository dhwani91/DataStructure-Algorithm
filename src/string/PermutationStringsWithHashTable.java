package string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PermutationStringsWithHashTable {
	public Boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val + 1);
			} else
				map.put(ch, 1);
		}
		for (char ch : s2.toCharArray()) {
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				if (val == 0) {
					return false;
				}
				val--;
				map.put(ch, val);

			} else {
				return false;
			}
		}
		Set<Character> keys = map.keySet();
		for (Character k : keys) {
			if (map.get(k) != 0) {
				return false;
			}
			

		}
		return true;

	}
}

class PermutationStringsWithHashTableApp {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 1st string");
		String s1 = sc.nextLine();
		System.out.println("Enter 2st string");
		String s2 = sc.nextLine();
		PermutationStringsWithHashTable p = new PermutationStringsWithHashTable();
		System.out.println(s1 + " and " + s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
		s1 = "1";
		s2 = "";
		System.out.println(s1 + " and " + s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
	}
}
