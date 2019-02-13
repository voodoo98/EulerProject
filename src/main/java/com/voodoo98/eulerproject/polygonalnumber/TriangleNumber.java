package com.voodoo98.eulerproject.polygonalnumber;

public class TriangleNumber extends PolygonalNumber {

	public static long getTriangle(final long n) {
		return n * (n + 1) / 2;
	}

	public static boolean isTriangle(final long n) {
		final double sqrt = Math.sqrt(8 * n + 1);
		return sqrt == (long) sqrt;
	}

	public static int sumWordToNumber(final String word) {
		int sum = 0;
		for (int j = 0; j < word.length(); j++) {
			sum += word.charAt(j) - 64;
		}
		return sum;
	}

	@Override
	protected long formula(final long n) {
		return getTriangle(n);
	}
}
