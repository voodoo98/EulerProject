package com.voodoo98.eulerproject.pythagoreantriplet;

public class PythagoreanTriplet {

	private final long a;
	private final long b;
	private final long c;

	public PythagoreanTriplet(final long a, final long b, final long c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.checkConditions();
	}

	public boolean isPythagoreanTriplet() {
		return this.a * this.a + this.b * this.b == this.c * this.c;
	}

	public static boolean isPythagoreanTriplet(final long a, final long b, final long c) {
		return a * a + b * b == c * c;
	}

	public long getTripletProduct() {
		return this.a * this.b * this.c;
	}

	private void checkConditions() {
		if (this.b < this.a || this.c < this.b) {
			throw new IllegalArgumentException("Not in proper order: a < b < c!");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.a ^ this.a >>> 32);
		result = prime * result + (int) (this.b ^ this.b >>> 32);
		result = prime * result + (int) (this.c ^ this.c >>> 32);
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
		final PythagoreanTriplet other = (PythagoreanTriplet) obj;
		if (this.a != other.a) {
			return false;
		}
		if (this.b != other.b) {
			return false;
		}
		if (this.c != other.c) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PythagoreanTriplet [a=" + this.a + ", b=" + this.b + ", c=" + this.c + "]";
	}

}
