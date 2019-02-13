package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution056 {

	private static final int LIMIT = 100;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		long max = 0;
		for (int a = 1; a < LIMIT; a++) {
			BigInteger base = new BigInteger(a);
			for (int b = 1; b < LIMIT; b++) {
				base = base.multiply(a);
				max = Math.max(base.sumDigits(), max);
			}
		}
		return max;
	}
}
