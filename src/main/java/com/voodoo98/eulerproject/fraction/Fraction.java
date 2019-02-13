package com.voodoo98.eulerproject.fraction;

public class Fraction implements Comparable<Fraction> {

	private final long numerator;
	private final long denominator;

	public Fraction(final long a, final long b) {
		this.numerator = a;
		this.denominator = b;
	}

	public long getNumerator() {
		return this.numerator;
	}

	public long getDenominator() {
		return this.denominator;
	}

	public double getValue() {
		return (double) this.numerator / this.denominator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.denominator ^ this.denominator >>> 32);
		result = prime * result + (int) (this.numerator ^ this.numerator >>> 32);
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
		final Fraction other = (Fraction) obj;
		if (this.denominator != other.denominator) {
			return false;
		}
		if (this.numerator != other.numerator) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	@Override
	public int compareTo(final Fraction o) {
		return Double.compare(this.getValue(), o.getValue());

	}

}
