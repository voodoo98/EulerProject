package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution055 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		int counter = 0;
		OUTER: for (long i = 1; i < 10000; i++) {
			BigInteger number = new BigInteger(i);
			for (int it = 0; it < 50; it++) {
				number = number.add(new BigInteger(number).reverse());
				if (number.isPalindrome()) {
					continue OUTER;
				}
			}
			counter++;
		}
		return counter;
	}
}
