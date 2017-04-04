package string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CrackingCoding5 {
	void stringCompression(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			char prev=ch;
			System.out.println("prev "+prev);
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val + 1);
			} else

				map.put(ch, 1);
		}

		for (Character key : map.keySet()) {
			Integer countFromMap = map.get(key);
			System.out.print(key + "" + countFromMap);

		}
	}

}

class CrackingCoding5App {
	public static void main(String[] args) {
		System.out.println("enter the String :::");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		CrackingCoding5 a = new CrackingCoding5();
		a.stringCompression(s1);

	}
}
