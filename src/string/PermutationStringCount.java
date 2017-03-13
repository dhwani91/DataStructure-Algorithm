package string;

import java.util.Scanner;

public class PermutationStringCount {
	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letter = new int[256];
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letter[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letter[c] < 0) {
				return false;
			}

		}
		return true;
	}
}

class permutationStringCountApp {
	public static void main(String[] args) {
		PermutationStringCount s = new PermutationStringCount();
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();
		System.out.println("Enter your String : ");
		System.out.println("string 1   " + input1 + "string 2   " + input2);
		Boolean flag = s.permutation(input1, input2);
		if (flag) {
			System.out.println("Two Strings anagram");
		} else
			System.out.println("Two Strings are not anagram");
	}
}
