package truthtable;
import java.math.BigInteger;
import java.util.Random;

/**
 * File Name: TruthTable.java Print 'n' input truth table
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

class TruthTable {
	String s = new String();
	private int n;

	TruthTable(int n) {
		this.n = n;
		printTruthTable();
	}

	private void printTruthTable() {

		long rows = (long) Math.pow(2, n);
		if (n < 8) {
			for (int i = 0; i < rows; i++) {
				for (int j = n - 1; j >= 0; j--) {
					System.out.print((i / (int) Math.pow(2, j)) % 2 + " ");
				}
				System.out.println();
			}
		}

		System.out.println("For" + " " + n + " " + "inputs" + ", Table size is " + rows);
		System.out.println(" ");
		// WRITE CODE HERE.
		// Show truth table for n < 8 along with print number of rows in truth
		// table
		// For others just print number of rows in truth table, but internally
		// it should build truth table like n < 8
	}
	private static void testBench() {
		// CANNOT CHANGE BELOW
		for (int i = 1; i < 40; ++i) {
			System.out.println("------------Truth table of " + i + " inputs function --------------");
			TruthTable t = new TruthTable(i);
		}
	}

	public static void main(String[] args) {
		// CANNOT CHANGE BELOW
		System.out.println("TruthTable.java");
		testBench();
		System.out.println("Done");
	}
}