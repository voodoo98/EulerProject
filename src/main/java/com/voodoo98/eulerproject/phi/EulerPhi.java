package com.voodoo98.eulerproject.phi;

import java.util.List;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.voodoo98.eulerproject.prime.PrimeFactor;
import com.voodoo98.eulerproject.prime.PrimeFactorDecomposition;

public class EulerPhi {

	private final PrimeFactorDecomposition pfd;
	private final LoadingCache<Integer, Integer> cache = CacheBuilder.newBuilder().build(new CacheLoader<Integer, Integer>() {

		@Override
		public Integer load(final Integer n) throws Exception {
			return EulerPhi.this.phi(n);
		}
	});

	public EulerPhi() {
		this.pfd = new PrimeFactorDecomposition();
	}

	public int getPhi(final int n) {
		return this.cache.getUnchecked(n);
	}

	public void putIntoCache(final int key, final int value) {
		this.cache.put(key, value);
	}

	public int phi(final int n) {
		if (!this.pfd.getPrimeSieve().isPrime(n)) {
			final List<PrimeFactor> primeFactors = this.pfd.count(n);
			double d = 1d;
			for (final PrimeFactor primeFactor : primeFactors) {
				d *= 1d - 1d / primeFactor.getPrime();
			}
			return (int) Math.round(n * d);
		} else {
			return n - 1;
		}
	}

	public long getSize() {
		return this.cache.size();
	}
}
