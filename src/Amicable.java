public class Amicable {
	static long[] amicableArray = new long[100000000];
	private int max;

	Amicable(int n) {
		this.max = n;
	}

	// public static final double top = 100000000;
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int counter() {
		int count = 0;
		count += 1;
		return count;
	}

	public int sumOfDivisors(int n2) {
		int tempSum = 1;
		for (int i = 2; i <= Math.sqrt(n2); i++) {
			if (n2 % i == 0) {
				tempSum += i + n2 / i;
			}
		}
		return tempSum;
	}

	public static void main(String[] args) {
		int n = 100000000;
		Amicable m = new Amicable(n);
		long startTime = System.nanoTime();
		int count = 0;

		for (int a = 220; a < n; a++) {

			Prime: if (m.isPrime(a)) {
				break Prime;
			} // check number is prime or not,prime number is not amicable
			if (amicableArray[a] == 1) {// to avoid duplicate number pair
				continue;
			}
			int n2 = m.sumOfDivisors(a);
			int n3 = m.sumOfDivisors(n2);

			if (a == n2) {
				continue; // covers the a != b condition
			}
			if (n3 == a) {
				count++;
				System.out.println(count + "  :  " + a + " and " + n2);
				n3 = n2;
				amicableArray[a] = 1;
				amicableArray[n3] = 1;

			}

		}

		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime) / 1000000000);
	}

}