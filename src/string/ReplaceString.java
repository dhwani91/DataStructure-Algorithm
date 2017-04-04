package string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ReplaceString {
void replace(String s,String insert){
	HashMap<Character, Integer> map=new HashMap<>();
	;
	for(char ch:s.toCharArray()){
		if(ch=='\0'){
			for(char in:insert.toCharArray()){
				if(map.containsKey(in)){
					int val=map.get(in);
					map.put(in, val+1);
				}
				else
					map.put(in, 1);
			}
		}
		if(map.containsKey(ch)){
			int val=map.get(ch);
			map.put(ch, val+1);
			
		}
		map.put(ch, 1);
	}
	for (Character key : map.keySet()) {
		Integer countFromMap = map.get(key);
		System.out.print(key);

	}
	
	
}
}
class ReplaceStringapp{
	public static void main(String[] args) {
		System.out.println("Enter the string");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String insert="%20";
		ReplaceString re=new ReplaceString();
		re.replace(s, insert);
		
		
	}
}
