package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.util.List;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution050 {

	public static void main(final String[] args) throws IOException {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() throws IOException {
		final PrimeSieve primeSieve = new PrimeSieve();
		primeSieve.count();
		final List<Integer> primes = primeSieve.getPrimes();
		int maxCount = 0;
		int result = 0;
		for (int j = 0; j < 10; j++) {
			int sum = 0;
			for (int i = j; i < primes.size() / 10; i++) {
				sum += primes.get(i);
				if (sum < 1_000_000 && primeSieve.isPrime(sum) && maxCount <= i) {
					maxCount = i;
					result = sum;
				}
			}
		}
		return result;
	}

}
