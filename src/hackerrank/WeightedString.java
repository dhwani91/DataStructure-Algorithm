package hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WeightedString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		String str=s.toLowerCase();
	
		for (int a0 = 0; a0 < n; a0++) {
			int x = in.nextInt();
			int len = s.length();
			int val=1;
			HashMap<Integer, Integer>map=new HashMap<>();
			for(int ch:str.toCharArray()){
				if(map.containsKey(ch)){
					val=map.get(ch);
					val=val+1;
					map.put(ch, val);
				}
			
				map.put(ch, 1);
			}
			Set<Integer> keys = map.keySet();
			for (Integer k : keys) {
				
				System.out.println(k);
				

			}

		}
	}
}
