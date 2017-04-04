// here compress string aaabbcc
// original string is greater than compressed one
// no use of additional data structure

package string;

import java.util.Scanner;

public class CompressString {
	String compress(String str){
		int len=str.length();
		int count=0;
		char last=str.charAt(0);
		StringBuffer myStr= new StringBuffer();
		for(int i=0;i<len;i++){
		
			if(str.charAt(i)==last){
				count++;
			}
			else{
				myStr.append(last);
				myStr.append(count);
				last=str.charAt(i);
				count=1;
			}
			
		}
		myStr.append(last);
		myStr.append(count);
		return myStr.toString();
		
	}
	

}
class CompressStringApp{
	public static void main(String[] args) {
		System.out.println("Enter the string  ::");
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine();
		CompressString cs=new CompressString();
		String compressedStr=cs.compress(str);
		System.out.println("Compressed string:"+compressedStr);
		
	}
}