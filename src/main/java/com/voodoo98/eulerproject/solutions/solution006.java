package com.voodoo98.eulerproject.solutions;

public class solution006 {

	public static void main(final String[] args) {
		System.err.println(getSquareOfSum(100) - getSumOfSquare(100));
	}

	private static long getSquareOfSum(final int n) {
		return (long) Math.pow(n * (n + 1) / 2, 2);
	}

	private static long getSumOfSquare(final int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += Math.pow(i, 2);
		}
		return sum;
	}
}
