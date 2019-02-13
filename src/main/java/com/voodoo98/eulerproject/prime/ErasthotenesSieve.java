package com.voodoo98.eulerproject.prime;

public class ErasthotenesSieve implements Sieve {

	private final int[] factors;
	private final int limit;

	public ErasthotenesSieve() {
		this(1_000_000);
	}

	public ErasthotenesSieve(final int limit) {
		this.limit = limit;
		this.factors = new int[limit];
	}

	public int getCount(final int number) {
		return 0 <= number ? this.factors[number] : 0;
	}

	@Override
	public void count() {
		for (int i = 2; i < this.limit; i++) {
			if (this.factors[i] == 0) {
				for (int j = i; j < this.limit; j += i) {
					this.factors[j]++;
				}
			}
		}
	}

	@Override
	public int getLimit() {
		return this.limit;
	}

}
