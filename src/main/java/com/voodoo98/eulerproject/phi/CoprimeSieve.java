package com.voodoo98.eulerproject.phi;

import java.util.List;

import com.voodoo98.eulerproject.prime.PrimeFactor;
import com.voodoo98.eulerproject.prime.PrimeFactorDecomposition;

public class CoprimeSieve {

    private static final int DEFAULT_LIMIT = 1_000_000;
    private final long[] array;
    private final int limit;

    public CoprimeSieve() {
	this(DEFAULT_LIMIT);
    }

    public CoprimeSieve(final int limit) {
	this.limit = limit;
	this.array = new long[limit];
	this.initArray();
    }

    private void initArray() {
	for (int i = 1; i < this.limit; i++) {
	    this.array[i] = i;
	}
    }

    public long[] count() {
	final PrimeFactorDecomposition pfd = new PrimeFactorDecomposition(this.limit);
	final List<PrimeFactor> count = pfd.count(this.limit);
	for (final PrimeFactor primeFactor : count) {
	    System.out.println(primeFactor);
	    for (int i = 0; i < this.limit; i++) {
		final int j = primeFactor.getPrime() * i;
		if (0 <= j && j < this.limit) {
		    this.array[j] = 0;
		}
	    }
	}
	return this.array;
    }

    public boolean isCoPrime(final int n) {
	return 0 < this.array[n];
    }

}
