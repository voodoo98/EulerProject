package com.voodoo98.eulerproject.prime;

import java.text.MessageFormat;

public class PrimeFactor {

	private final int prime;
	private final int count;

	public PrimeFactor(final int prime, final int count) {
		this.prime = prime;
		this.count = count;
	}

	public int getPrime() {
		return this.prime;
	}

	public int getCount() {
		return this.count;
	}

	public int intValue() {
		return (int) Math.pow(this.getPrime(), this.getCount());
	}

	public long longValue() {
		return (long) Math.pow(this.getPrime(), this.getCount());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.count;
		result = prime * result + this.prime;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final PrimeFactor other = (PrimeFactor) obj;
		if (this.count != other.count) {
			return false;
		}
		if (this.prime != other.prime) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0}^{1}", this.prime, this.count);
	}

}
