package com.voodoo98.eulerproject.solutions;

public class solution053 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {

		int counter = 0;
		for (int n = 1; n <= 100; n++) {
			for (int k = 0; k <= n; k++) {
				counter += binom(n, k) ? 1 : 0;
			}
		}

		return counter;
	}

	private static boolean binom(int n, final int k) {
		final int min = k < n - k ? k : n - k;
		long bin = 1;
		for (int i = 1; i <= min; i++) {
			bin *= n;
			bin /= i;
			if (1_000_000 < bin) {
				return true;
			}
			n--;
		}
		return false;
	}

}
