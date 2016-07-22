import java.*;
import java.math.*;
class Prime{

	public static void main(String[] args) {
//		int n = 2;
//		for (int i = 0 ; i != (1<<n) ; i++) {
//		    String s = Integer.toBinaryString(i);
//		    while (s.length() != n) {
//		        s = '0'+s;
//		    }
//		    System.out.println(""+s+"  ");
//		}
	     
		int value = 28;
	    for(int i = 1, j = 0; i < 256; i = i << 1, j++)
	        System.out.print(j + " " + ((value & i) > 0 ? 1 : 0));
}
	
}