package com.voodoo98.eulerproject.solutions;

import java.io.IOException;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution051 {

	public static void main(final String[] args) throws IOException {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() throws IOException {
		final PrimeSieve primeSieve = new PrimeSieve();
		primeSieve.count();
		final int length = 6;
		int firstElement = 0;
		for (int p = 100000; p < 1000000; p++) {
			for (int i = 1; i < length - 1; i++) {
				for (int j = i + 1; j < length; j++) {
					for (int k = j + 1; k < length + 1; k++) {
						int sum = 0;
						firstElement = 0;
						for (int d = 0; d < 10; d++) {
							if (0 < d || d == 0 && k != length) {
								final int changeDigit = changeDigit(changeDigit(changeDigit(p, i, d), j, d), k, d);
								if (primeSieve.isPrime(changeDigit)) {
									if (firstElement == 0) {
										firstElement = changeDigit;
									}
									sum++;
								}
							}
						}
						if (8 == sum) {
							return firstElement;
						}
					}
				}
			}
		}
		return firstElement;
	}

	private static int changeDigit(final int number, final int digitPlace, final int digit) {
		final int tenPow = (int) Math.pow(10, digitPlace);
		final int tenPowDiv10 = tenPow / 10;
		final int upperPart = number / tenPow;
		final int lowerPart = number % tenPowDiv10;
		return upperPart * tenPow + digit * tenPowDiv10 + lowerPart;
	}

}
