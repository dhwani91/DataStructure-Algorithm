/**
 * File Name: Length.java
 *
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2015
 */

class Length {
	private static final IntUtil u = new IntUtil();
	// YOU CANNOT ADD ANY VARIABLE HERE

	private static int length_easy(int[] s, int x) {
		// CANNOT CHANGE BELOW
		int l = 0;
		int gx = x;
		while (true) {
			if (s[x] == gx) {
				return l;
			}
			x = s[x];
			++l;
		}
	}

	private static int length(int[] s, int x) {
		if (s[x] == x) { // if s[3]==3 then return count 0
			return 0;
		}
		int temp = s[x];// temp variable for swapping elements of array
		s[x] = s[temp];
		s[temp] = temp;
		int count = 1 + length(s, x); 
		s[temp] = s[x];// swapping to get original array
		s[x] = temp;
		return count;// return length of array
	}

	// NOTHING CAN BE CHANGED BELOW
	public static void testbed() {
		// CANNOT CHANGE BELOW
		int s[] = { 5, 1, 0, 4, 2, 3 };
		int y = length_easy(s, 3);
		System.out.println("length_easy y = " + y);
		u.myassert(y == 4);
		int b[] = { 5, 1, 0, 4, 2, 3 };
		int x = length(s, 3);
		System.out.println("length x = " + x);
		u.myassert(x == y);
		for (int i = 0; i < s.length; ++i) {
			u.myassert(s[i] == b[i]);
		}
		System.out.println("Assert passed");
	}

	public static void testbed1() {
		// CANNOT CHANGE BELOW
		int s[] = { 5, 1, 0, 4, 2, 3 };
		int b[] = { 5, 1, 0, 4, 2, 3 };
		int l = s.length;
		for (int j = 0; j < l; ++j) {
			System.out.println("---------------------j = " + j + "------------------");
			int y = length_easy(s, j);
			System.out.println("length_easy y = " + y);
			int x = length(s, j);
			System.out.println("length x = " + x);
			u.myassert(x == y);
			for (int i = 0; i < s.length; ++i) {
				u.myassert(s[i] == b[i]);
			}
			System.out.println("---------------------Assert passed--------------------");
		}
	}

	public static void main(String[] args) {
		System.out.println("Length.java");
		testbed();
		testbed1();
	}
}
