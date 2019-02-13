package com.voodoo98.eulerproject.solutions;

public class solution071 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result by trying: " + count());
		System.err.println("Result by theory: " + count2());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final int d = 1_000_000;
		final int value = (int) (d * 3d / 7) - 1;
		return value;
	}

	// http://www.mathblog.dk/project-euler-71-proper-fractions-ascending-order/
	private static long count2() {
		final long a = 3;
		final long b = 7;
		final int limit = 1000000;
		long r = 0;
		long s = 1;
		long lowerbound = 2;
		int q = limit;

		while (lowerbound <= q) {
			final long p = (a * q - 1) / b;
			if (r * q < p * s) {
				s = q;
				r = p;
				lowerbound = s / (a * s - b * r);
			}
			q--;
		}
		return r;
	}

}
