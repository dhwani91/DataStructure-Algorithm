package string;

import java.util.Scanner;

public class ReverseString {
	public void reverse(String s) {
		int i = 0;
		while (s.charAt(i) != '\0') {
			i++;

		}
		char[] char_set = new char[i];
		for (int n = 0; n <= i / 2; n++) {
			char temp = s.charAt(n);
			char temp2 = s.charAt(i-1-n);
			char_set[n] = temp2;
			char_set[i-1-n] = temp;
		}
		print(char_set, i);
	}

	void print(char[] char_set, int len) {
		
		for ( int i= 0; i <=len-1; i++) {
			System.out.print(char_set[i]);
		}

	}
}

class reverseStringApp {
	public static void main(String[] args) {
		ReverseString s = new ReverseString();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("Enter your String : ");
		System.out.println(input);
		s.reverse(input);

	}
}
