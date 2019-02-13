package com.voodoo98.eulerproject.prime;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.utils.MathUtils;

public class PrimeFactorDecomposition {

	private final PrimeSieve primeSieve;

	public PrimeFactorDecomposition() {
		this.primeSieve = new PrimeSieve();
		this.primeSieve.count();
	}

	public PrimeFactorDecomposition(final long n) {
		this.primeSieve = new PrimeSieve((int) n);
		this.primeSieve.count();
	}

	public List<PrimeFactor> count(final long number) {
		final List<PrimeFactor> result = new ArrayList<>();
		long localNumber = number;
		if (this.primeSieve.isPrime(number)) {
			result.add(new PrimeFactor((int) number, 1));
		} else {
			if (number % 2 == 0) {
				localNumber = this.addPrimeFactor(result, localNumber, 2);
			}
			final int startPrime = (int) (3 - number % 2);
			for (int p = startPrime; p < number / 2 + 1; p += 2) {
				if (this.primeSieve.isPrime(p)) {
					localNumber = this.addPrimeFactor(result, localNumber, p);
				}
			}

		}
		return result;
	}

	private Long addPrimeFactor(final List<PrimeFactor> result, long localNumber, final int prime) {
		int counter = 0;
		while (localNumber % prime == 0) {
			localNumber /= prime;
			counter++;
		}
		if (0 < counter) {
			result.add(new PrimeFactor(prime, counter));
		}
		return localNumber;
	}

	public long getSumOfFactors(final int number) {
		return this.count(number).parallelStream().mapToLong(PrimeFactor::longValue).sum();
	}

	public PrimeSieve getPrimeSieve() {
		return this.primeSieve;
	}

}
