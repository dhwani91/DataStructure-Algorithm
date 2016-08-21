package series;
import java.math.BigInteger;

/**
 * File Name: Series.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

class Series {
	private static final IntUtil u = new IntUtil();

	private static void testLog(int start, int end, int incr) {
		System.out.println();
		System.out.format("%5s%25s%25s%25s", "n", "base10", "base2", "base e");
		System.out.println();
		for (int i = start; i <= end; i = i + incr) {
			System.out.format("%5s%25s%25s%25s", i, convertLog(10, i), convertLog(2, i), Math.log(i));
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	private static double convertLog(int base, int num) {
		return Math.log(num) / Math.log(base);
	}

	private static void testLog() {
		System.out.println("1. testLog() Output: ");
		testLog(1, 10, 1);
		testLog(10, 100, 10);
		testLog(100, 1000, 100);
		testLog(1000, 10001, 9000);
	}

	/*
	 * 1 + 1/2 + 1/4 + 1/8 + 1/16 +... + = 2
	 */
	private static void seriesConvergesAbsolutely() {
		System.out.println();
		System.out.println("2. seriesConvergesAbsolutely() Output: ");
		System.out.println();
		// WRITE CODE HERE for n = 100
		int n = 100;
		double sum = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Converges Absolutely Series: ");
		for (int i = 0; i <= n; i++) {
			double pow = Math.pow(2, i);
			sum = sum + 1 / pow;
			if (i != n)
				sb.append(1 + "/" + (int) pow + " + ");
			else
				sb.append(1 + "/" + (int) pow);
		}
		System.out.println(sb.toString());
		System.out.println("Sum= " + sum);
	}

	/*
	 * 1 + 1/2 + 1/3 + 1/4 + 1/5 + .. =
	 */
	private static void harmonicSeries() {
		// WRITE CODE HERE for n = 100
		System.out.println();
		System.out.println("3. harmonicSeries() Output: ");
		System.out.println();
		int n = 100;
		double sum = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Harmonic Series: ");
		for (int i = 1; i <= n; i++) {
			sum = sum + (double) 1 / i;
			if (i != n)
				sb.append(1 + "/" + i + " + ");
			else
				sb.append(1 + "/" + i);
		}
		System.out.println(sb.toString());
		System.out.println("Expected Sum of Harmonic series of " + " n " + " number is " + (Math.log(n) + 0.57721566));
		System.out.println("Calculated Sum of Harmonic series of " + n + " numbers is " + " " + sum);

	}

	private static void chess() {
		int max=64;
		System.out.println();
		System.out.println("4. chess() Output: ");
		System.out.println();
		BigInteger total=BigInteger.ZERO;
		BigInteger one=BigInteger.ONE;
		for(int i=0;i<max;++i){
			if (i==0){
				one=one.shiftLeft(0);
			}
			else{
				one=one.shiftLeft(1);
			}
			total=total.add(one);
			System.out.println("On Square " + " " + (i + 1) + " = " + one);
		}
		
//		BigInteger bi1, bi2;
//		BigInteger sum = BigInteger.valueOf(0);
//		for (int i = 0; i < 64; i++) {
//			bi1 = new BigInteger("2");
//			bi2 = bi1.pow(i);
//			sum = sum.add(bi2);
//			System.out.println("On Square" + " " + (i + 1) + " = " + bi2);
//			// perform pow operation on bi1 using exponent
//		}
//		System.out.println("Total rice " + sum);
	}

	private static void testbed() {
		testLog();
		seriesConvergesAbsolutely();
		harmonicSeries();
		chess();
	}

	public static void main(String[] args) {
		System.out.println("Series.java");
		testbed();
		System.out.println("Done");
	}
}
