package com.voodoo98.eulerproject.permutation;

public class Pair {

	private final int a;
	private final int b;

	public Pair(final int a, final int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.a;
		result = prime * result + this.b;
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
		final Pair other = (Pair) obj;
		if (this.a != other.a) {
			return false;
		}
		if (this.b != other.b) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pair [a=" + this.a + ", b=" + this.b + "]";
	}

}
