package string;

import java.util.Scanner;

public class RemoveRepeat {
	void remove(char[]str,int length){
		int spaceCount=0,newLength = 0,i;
		for( i=0;i<length;i++){
			if(str[i] == 'd'){
				spaceCount++;
			}
			
		}
		newLength=newLength+newLength*2;
		str[newLength]='d';
		for(i=length;i>=0;i--){
			if(str[i-1]=='d'){
				str[newLength-1]='0';
				str[newLength-2]='2';
				str[newLength-3]='%';
				newLength=newLength-3;
						
			}
			else{
				str[newLength-1]=str[i];
				newLength=newLength-1;
				
			}
		}
		System.out.println(str[newLength]);
	}


}
class RemoveRepeatApp{
	public static void main(String[] args) {
		RemoveRepeat s = new RemoveRepeat();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("Enter your String : ");
		System.out.println(input);
		char[] c=input.toCharArray();
		int len=c.length;
		s.remove(c, len);
	}
}
