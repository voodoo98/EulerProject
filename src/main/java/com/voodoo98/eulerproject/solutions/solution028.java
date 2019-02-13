package com.voodoo98.eulerproject.solutions;

public class solution028 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count(1001));
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count(final int n) {
		long sum = 0;
		for (int i = 3; i <= n; i += 2) {
			final int pow = (int) Math.pow(i, 2);
			sum += 2 * (2 * pow - 3 * (i - 1));
		}
		return sum + 1;
	}
}
