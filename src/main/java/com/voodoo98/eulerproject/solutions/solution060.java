package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.voodoo98.eulerproject.prime.PrimeSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution060 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final PrimeSieve primeSieve = new PrimeSieve(9000);
		primeSieve.count();

		final Map<Integer, List<Integer>> preload = preloadConcatPrimes(primeSieve, 1070);

		for (final Integer p1 : preload.keySet()) {
			for (final Integer p2 : preload.get(p1)) {
				for (final Integer p3 : preload.get(p2)) {
					if (checkConcatPrimes(primeSieve, p1, p3)) {
						for (final Integer p4 : preload.get(p3)) {
							if (checkConcatPrimes(primeSieve, p1, p4) && checkConcatPrimes(primeSieve, p2, p4)) {
								for (final Integer p5 : preload.get(p4)) {
									if (checkConcatPrimes(primeSieve, p1, p5) && checkConcatPrimes(primeSieve, p2, p5) && checkConcatPrimes(primeSieve, p3, p5)) {
										System.err.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5);
										return p1 + p2 + p3 + p4 + p5;
									}
								}
							}
						}
					}
				}
			}
		}

		return -1;

	}

	private static Map<Integer, List<Integer>> preloadConcatPrimes(final PrimeSieve primeSieve, final int primeCount) {
		final Map<Integer, List<Integer>> pairMap = new HashMap<>();
		final List<Integer> primes = primeSieve.getPrimes();
		for (int i = 0; i < primeCount; i++) {
			final int p1 = primes.get(i);
			final List<Integer> list = new ArrayList<>();
			for (int j = i + 1; j < primeCount; j++) {
				final int p2 = primes.get(j);
				if (checkConcatPrimes(primeSieve, p1, p2)) {
					list.add(p2);
				}
			}
			pairMap.put(p1, list);
		}
		return pairMap;
	}

	private static boolean checkConcatPrimes(final PrimeSieve primeSieve, final long p1, final long p2) {
		return p1 != p2 && isConcatPrime(primeSieve, p1, p2) && isConcatPrime(primeSieve, p2, p1);

	}

	private static boolean isConcatPrime(final PrimeSieve primeSieve, final long p1, final long p2) {
		final int lengthOfNumber = NumberUtils.lengthOfNumber(p2);
		final int prime = (int) (p1 * Math.pow(10, lengthOfNumber) + p2);
		return primeSieve.isPrime(prime);
	}
}
