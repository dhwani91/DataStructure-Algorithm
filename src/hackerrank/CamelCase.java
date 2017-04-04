package hackerrank;

import java.util.Scanner;

public class CamelCase {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	         String[] words = s.split("[A-Z]");
	     
	        
	        System.out.println(words.length);
	    }
}
