package com.voodoo98.eulerproject.permutation;

public class Triple {

	private final int a;
	private final int b;
	private final int c;

	public Triple(final int a, final int b, final int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	public int getC() {
		return this.c;
	}

	@Override
	public String toString() {
		return "Triple [a=" + this.a + ", b=" + this.b + ", c=" + this.c + "]";
	}

}
