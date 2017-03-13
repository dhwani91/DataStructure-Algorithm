package string;

import java.util.Scanner;

public class UniqueString {
	Boolean isUnique(String input) {
		int len = input.length();
		if (len > 128) {
			return false;
		}
		Boolean[] char_set = new Boolean[256];
		for (int i = 0; i < len; i++) {
			int val = input.charAt(i);		
			if(char_set[val]!=null){
				return false;
			}
			char_set[val]=true;		
		}	
		return true;
	}
}
class UniqueStringApp {
	public static void main(String[] args) {
		UniqueString s = new UniqueString();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("Enter your String : ");
		System.out.println(input);
		Boolean flag = s.isUnique(input);
		if (flag) {
			System.out.println("This String is Unique");
		}
		else{
		System.out.println("This String is not Unique");
		}
	}
}
