package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.Prime;

public class solution058 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		int number = 1;
		int add = 2;
		int primCount = 0;
		int count = 1;
		do {
			for (int j = 0; j < 4; j++) {
				number += add;
				if (j < 3 && Prime.isPrime(number)) {
					primCount++;
				}
				count++;
			}
			add += 2;
		} while (10 <= 100d * primCount / count);
		return (long) Math.sqrt(number);
	}
}
