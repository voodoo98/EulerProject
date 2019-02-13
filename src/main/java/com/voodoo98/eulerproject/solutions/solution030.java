package com.voodoo98.eulerproject.solutions;

import java.util.Arrays;

public class solution030 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count(5));
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count(final int h) {
		final int[] pows = new int[10];
		for (int i = 0; i < pows.length; i++) {
			pows[i] = (int) Math.pow(i, h);
		}

		long allSum = 0;
		for (int i = 2; i < 1000000; i++) {
			final String str = String.valueOf(i);
			final int[] array = stringToIntArray(str);
			long sum = 0;
			for (final int element : array) {
				sum += pows[element];
			}
			if (sum == i) {
				allSum += sum;
			}
		}
		return allSum;
	}

	private static int[] stringToIntArray(final String numberString) {
		return Arrays.stream(numberString.split("")).mapToInt(Integer::parseInt).toArray();
	}
}
