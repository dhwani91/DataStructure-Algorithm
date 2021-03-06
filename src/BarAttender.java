import java.util.Random;

import javax.print.attribute.HashAttributeSet;

/**
 * File Name: BarAttender.java Simulates Bar attender puzzle
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2014
 */

class BarAttender {
	private int min; // Work in the range of min to max
	private int max;

	BarAttender(int min, int max) {
		// WRITE CODE
		this.min = min;
		this.max = max;
	}
/*
 * Returns number of steps(counts)for guessing number
 * @param g Number to be guessed
 * @param show boolean value
 * 
 * */
	private int guess(int g, boolean show) {
		// WRITE CODE
		int upper = max;
		int lower = min;
		int count = 0;
		while (true) {
			int median = (upper + lower) / 2;
			++count;
			if (show) {
				System.out.println(count+":"+" "+"l=" + lower + "   " + "r="+ upper + "   " + "m=" + median);
			}
			if (median == g) {
				if (show) {
					System.out.println("Number to be guessed" +" "+ g);
					System.out.println("--------------");
				}
				break;
			}

			if (median < g) {
				lower = median + 1;

			}
			if (median > g) {
				upper = median - 1;
			}

		}
		return count;
	}

	private static void test(int s, int b, int m, boolean useRandom, boolean show) {
		// CANNOT CHANGE CODE BELOW. MUST USE AS IS
		Random r = new Random();
		int min = 9999;
		int max = 0;
		BarAttender h = new BarAttender(s, b);
		for (int i = 0; i < m; ++i) {
			int v = i + s;
			if (useRandom) {
				v = RandomInt.getRandomInt(r, s, b); // This gives number
														// between 1 to
														// 1000000-1
			}
			int n = h.guess(v, show);
			if (n > max) {
				max = n;
			}
			if (n < min) {
				min = n;
			}
		}
		System.out.print("For numbers  between " + s + " to " + b + " ");
		if (useRandom) {
			System.out.print("(random numbers)");
		} else {
			System.out.print("(not random numbers)");
		}
		System.out.println(" the min guess is " + min + " max guess is " + max);
	}

	private static void testBench() {
		// CANNOT CHANGE CODE BELOW. MUST USE AS IS
		test(1, 10, 10, false, true);
		test(1, 1000000, 1000000, false, false);
		test(1, 1000000, 1000, true, false);
	}

	public static void main(String[] args) {
		// CANNOT CHANGE CODE BELOW. MUST USE AS IS
		System.out.println("BarAttender.java");
		testBench();
		System.out.println("DONE");
	}

}
