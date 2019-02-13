package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution057 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {
		BigInteger numerator = new BigInteger(3);
		BigInteger denominator = new BigInteger(2);
		int counter = 0;
		for (int i = 0; i < 1000; i++) {
			final BigInteger oldDenominator = denominator;
			denominator = denominator.add(numerator);
			numerator = denominator.add(oldDenominator);
			if (denominator.length() < numerator.length()) {
				counter++;
			}
		}
		return counter;
	}

}
