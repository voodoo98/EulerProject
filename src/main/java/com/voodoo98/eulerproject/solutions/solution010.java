package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution010 {

	public static void main(final String[] args) {
		final int limit = 2_000_000;
		final PrimeSieve primeSieve = new PrimeSieve(limit);
		primeSieve.count();
		long sum = 0;
		for (int i = 2; i < limit; i++) {
			if (primeSieve.isPrime(i)) {
				sum += i;
			}
		}
		System.err.println("Result: " + sum);
	}
}
