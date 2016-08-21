package powerball;
import java.util.Arrays;

/**
 * File Name: PowerBall.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: IntUtil.java RandomInt.java PowerBall.java
 */

class PowerBall {
	/*
	 * ALL PRIVATE DATA BELOW CANNOT ADD ANY MORE MEMBER
	 */
	private int[] winningNumber;
	private int[] ticketNumber;
	private long cash;
	static private boolean display = true;
	static final long jackpot = 100000000;
	static private IntUtil u = new IntUtil();

	private void printNumbers() {
		if (display) {
			System.out.println("winningNumber ");
			u.pLn(winningNumber);
			System.out.println("ticketNumber  ");
			u.pLn(ticketNumber);
		}
	}

	public long cash() {
		return cash;
	}

	/*
	 * comparing Winning ticket numbers to given ticket numbers and count cash
	 * accordingly
	 */
	private void check() {
		if (isDuplicate())
			return;
		String matchNumber;
		int matchCount = 0;
		int powerBall = 0;

		for (int i = 0; i < winningNumber.length - 1; i++) {
			for (int j = 0; j < ticketNumber.length - 1; j++) {
				if (winningNumber[i] == ticketNumber[j]) {
					matchCount++;
				}

			}
		}
		if (winningNumber[winningNumber.length - 1] == ticketNumber[ticketNumber.length - 1]) {
			powerBall++;
		}
		matchNumber = matchCount + "|" + powerBall;
		switch (matchNumber) {
		case "0|1": {
			cash = 4;
			break;
		}
		case "1|1": {
			cash = 4;
			break;
		}
		case "2|1": {
			cash = 7;
			break;
		}
		case "3|0": {
			cash = 7;
			break;
		}
		case "3|1": {
			cash = 100;
			break;
		}
		case "4|0": {
			cash = 100;
			break;
		}
		case "4|1": {
			cash = 50000;
			break;
		}
		case "5|0": {
			cash = 1000000;
			break;
		}
		case "5|1": {
			cash = +jackpot;
			break;
		}
		default:
			break;

		}
	}

	/*
	 * checking duplicate number in white balls numbers of Powerball tickets
	 * 
	 * @return boolean true if it has duplicate number otherwise false
	 */
	private boolean isDuplicate() {
		for (int i = 0; i < ticketNumber.length - 2; i++) {
			for (int j = i + 1; j < ticketNumber.length - 2; j++) {
				if (ticketNumber[j] == ticketNumber[i]) {
					return true;
				}
			}
		}
		return false;
	}

	PowerBall(int[] w, int[] t) {
		winningNumber = w;
		ticketNumber = t;
		cash = 0;
		check();
	}

	private static void test1() {
		// CANNOT CHANGE BELOW
		int[] w = { 4, 8, 19, 27, 24, 10 };
		{
			int[] n = { 4, 8, 19, 27, 24, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 24, 27, 19, 8, 4, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 24, 27, 19, 8, 4, 5 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14, 5 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 124, 19, 119, 18, 14 };
			PowerBall x = new PowerBall(w, n);
		}
	}

	private static void testRandom() {

		// CANNOT CHANGE BELOW
		System.out.println("----------testRandom()  starts-------------");
		display = false;
		int[] w = { 4, 8, 19, 27, 24, 10 };
		int max = 1000000;
		long c = 0;
		System.out.println("Buying " + max + " tickets of worth " + max * 2 + "$");
		for (int i = 0; i < max; ++i) {
			int[] n = u.generateRandomNumber(6, true, 1, 60);
			PowerBall x = new PowerBall(w, n);
			if (x.cash() == jackpot) {
				System.out.println("Won Jacckpot");
			}
			c = c + x.cash();
		}
		long p = (c - (max * 2));
		System.out.println("Out of " + max + " times you win " + c + "$");
		if (p > 0) {
			System.out.println("Profit = " + p);
		} else {
			System.out.println("Loss = " + p);
		}
		System.out.println("----------testRandom()  ends-------------");
	}

	private static void testBench() {
		// CANNOT CHANGE BELOW
		test1();
		testRandom();
	}

	public static void main(String[] args) {
		// CANNOT CHANGE BELOW
		System.out.println("PowerBall.java");
		testBench();
		System.out.println("Done");
	}
}