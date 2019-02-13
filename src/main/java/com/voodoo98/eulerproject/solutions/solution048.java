package com.voodoo98.eulerproject.solutions;

public class solution048 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		long result = 0;
		final long modulo = 10000000000l;

		for (int i = 1; i < 1000; i++) {
			long pow = i;
			for (int j = 0; j < i - 1; j++) {
				pow *= i;
				if (Long.MAX_VALUE / 1000 < pow) {
					pow %= modulo;
				}
			}
			result += pow;
			result %= modulo;
		}
		return result;
	}
}
