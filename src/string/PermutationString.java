package string;

import java.util.Scanner;
import java.util.Arrays;

public class PermutationString {
	public String sort(String s) {
		char[] set = s.toCharArray();
		Arrays.sort(set);
		return new String(set);
	}
	public Boolean permutation(String s,String t){
		if(s.length()!=t.length()){
			return false;
		}
		return sort(s).equals(sort(t));
	}

}

class PermutationStringApp {
	public static void main(String[] args) {
		PermutationString s = new PermutationString();
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2=in.nextLine();
		System.out.println("Enter your String : ");
		System.out.println("string 1   "+input1 + "string 2   "+input2);
		Boolean flag=s.permutation(input1,input2);
		if(flag){
			System.out.println("Two Strings anagram");
		}
		System.out.println("Two Strings are not anagram");
	}
}
