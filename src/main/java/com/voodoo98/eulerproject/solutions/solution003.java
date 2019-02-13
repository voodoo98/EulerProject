package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution003 {

	public static void main(final String[] args) {

		final long number = 600851475143l;

		final PrimeSieve primeSieve = new PrimeSieve(1_000_000);
		primeSieve.count();
		int max = 0;
		for (int i = 2; i < Math.sqrt(number); i++) {
			if (primeSieve.isPrime(i) && number % i == 0) {
				max = i;
			}
		}
		System.err.println(max);

	}
}
