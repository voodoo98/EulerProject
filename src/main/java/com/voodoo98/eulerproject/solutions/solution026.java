package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;
import com.voodoo98.eulerproject.prime.PrimeSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution026 {

	public static void main(final String[] args) throws InterruptedException {

		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {
		final PrimeSieve primeSieve = new PrimeSieve(1000);
		primeSieve.count();
		final BigInteger bigInteger = new BigInteger();
		int max = 0;
		for (int i = 2; i < 1000; i++) {
			if (primeSieve.isPrime(i)) {
				final String value = bigInteger.divide(1, i).value();
				final int countRecurringCycles = NumberUtils.maxCountOfRecurringCycles(value);
				if (max < countRecurringCycles) {
					max = countRecurringCycles;
				}
			}
		}
		return max;
	}

}
