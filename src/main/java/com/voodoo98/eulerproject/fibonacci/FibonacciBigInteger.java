package com.voodoo98.eulerproject.fibonacci;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class FibonacciBigInteger {

	private BigInteger fibN2;
	private BigInteger fibN1;
	private BigInteger fibN;

	public FibonacciBigInteger() {
		this.reset();
	}

	public BigInteger count(final long n) {
		this.reset();
		for (int i = 3; i <= n; i++) {
			this.count();
		}
		return this.fibN;
	}

	public void count() {
		this.fibN = this.fibN1.add(this.fibN2);
		this.fibN2 = this.fibN1;
		this.fibN1 = this.fibN;
	}

	public BigInteger getFibonacci() {
		return this.fibN;
	}

	private void reset() {
		this.fibN = new BigInteger(1);
		this.fibN1 = new BigInteger(1);
		this.fibN2 = new BigInteger(1);
	}

}
