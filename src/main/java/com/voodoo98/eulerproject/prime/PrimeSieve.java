package com.voodoo98.eulerproject.prime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeSieve {

	private final boolean[] primeFlagArray;
	private final int limit;
	private List<Integer> collectedPrimes;

	public PrimeSieve() {
		this(1_000_000);
	}

	public PrimeSieve(final int limit) {
		this.limit = limit;
		this.primeFlagArray = new boolean[limit];
		Arrays.fill(this.primeFlagArray, true);
	}

	public boolean isPrime(final long i) {
		try {
			return 1 < i && this.primeFlagArray[(int) i];
		} catch (final Exception e) {
			return Prime.isPrime(i);
		}
	}

	public boolean isPrime(final int[] x) {
		return this.isPrime(this.turnArrToInt(x));
	}

	public void count() {
		this.primeFlagArray[0] = false;
		this.primeFlagArray[1] = false;
		for (int i = 2; i < this.limit; i++) {
			int j = i;
			while (0 < i * j && i * j < this.limit) {
				this.primeFlagArray[i * j] = false;
				j++;
			}
		}
	}

	public List<Integer> getPrimes() {
		if (this.collectedPrimes == null) {
			this.collectedPrimes = IntStream.range(0, this.primeFlagArray.length).filter(i -> this.isPrime(i)).mapToObj(i -> i).collect(Collectors.toList());
		}
		return this.collectedPrimes;
	}

	public long getLastPrime() {
		final int size = this.getPrimes().size();
		return this.getPrimes().get(size - 1);
	}

	public int getLimit() {
		return this.limit;
	}

	public int turnArrToInt(final int x[]) {
		int number = 0;
		for (int i = 0; i < x.length; i++) {
			number += (int) (x[i] * Math.pow(10, x.length - i - 1));
		}
		return number;
	}

}
