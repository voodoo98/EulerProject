package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution043 {

	private static final int[] divider = { 2, 3, 5, 7, 11, 13, 17 };

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final Permute permute = new Permute();
		permute.permute(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		long sum = 0;
		for (final Long perm : permute.getResultList()) {
			if (checkDivisibleProperty(NumberUtils.longConvertToArray(perm, 10))) {
				sum += perm;
			}
		}
		return sum;
	}

	private static boolean checkDivisibleProperty(final int[] array) {
		boolean result = true;
		for (int i = 0; i < divider.length; i++) {
			final int number = 100 * array[i + 1] + 10 * array[i + 2] + array[i + 3];
			if (number % divider[i] != 0) {
				result = false;
				break;
			}
		}
		return result;

	}

}