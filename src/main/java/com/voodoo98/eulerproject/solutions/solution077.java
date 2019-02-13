package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;
import com.voodoo98.eulerproject.utils.MathUtils;

public class solution077 {

	private static final int LIMIT = 5_000;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final PrimeSieve primeSieve = new PrimeSieve(100);
		primeSieve.count();
		final int[] array = primeSieve.getPrimes().stream().mapToInt(i -> i).toArray();
		int n = 0;
		int number = 1;
		while (n < LIMIT) {
			n = MathUtils.findCombinationsCount(number++, array);
		}
		return number - 1;
	}

}
