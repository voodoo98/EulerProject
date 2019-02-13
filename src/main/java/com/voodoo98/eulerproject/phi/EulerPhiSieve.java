package com.voodoo98.eulerproject.phi;

public class EulerPhiSieve {

	private static final int DEFAULT_LIMIT = 1_000_000;
	private final long[] phiArray;
	private final int limit;

	public EulerPhiSieve() {
		this(DEFAULT_LIMIT);
	}

	public EulerPhiSieve(final int limit) {
		this.limit = limit;
		this.phiArray = new long[limit];
		this.initArray();
	}

	private void initArray() {
		for (int i = 1; i < this.limit; i++) {
			this.phiArray[i] = i;
		}
	}

	public long[] count() {
		for (int i = 2; i < this.limit; i++) {
			if (this.phiArray[i] == i) {
				for (int j = i; j < this.limit; j += i) {
					this.phiArray[j] = (i - 1) * this.phiArray[j] / i;
				}
			}
		}
		return this.phiArray;
	}

}
