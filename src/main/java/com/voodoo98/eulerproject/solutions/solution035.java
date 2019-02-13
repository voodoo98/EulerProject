package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution035 {

	private static final int LIMIT = 1_000_000;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final PrimeSieve primeSieve = new PrimeSieve();
		primeSieve.count();

		int counter = 0;
		for (int i = 2; i < LIMIT; i++) {
			if (primeSieve.isPrime(i)) {
				boolean isAllPrime = true;
				final int[] circ = NumberUtils.countCircularNumbers(i);
				for (int j = 1; j < circ.length; j++) {
					if (!primeSieve.isPrime(circ[j])) {
						isAllPrime = false;
						break;
					}
				}
				if (isAllPrime) {
					counter++;
				}
			}
		}
		return counter;
	}
}
