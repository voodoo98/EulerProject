package com.voodoo98.eulerproject.solutions;

import java.util.HashSet;
import java.util.Set;

public class solution032 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {

		final Set<Integer> result = new HashSet<>();
		for (int i = 1; i < 2000; i++) {
			if (isAllDigitsDistinctAndPositive(i)) {
				for (int j = 1; j < 100; j++) {
					if (isAllDigitsDistinctAndPositive(j) && isAllDigitsDistinctAndPositive(i * j) && isAllDigitsDistinctAndPositive(i, j)) {
						result.add(i * j);
					}
				}
			}
		}
		return result.stream().mapToInt(Integer::intValue).sum();
	}

	public static boolean isAllDigitsDistinctAndPositive(int n) {
		if (n <= 0 || 999_999_999 < n) {
			return false;
		}

		boolean result = true;
		final boolean[] array = new boolean[10];
		while (0 < n) {
			final int d = n / 10;
			final int k = n - d * 10;
			n = d;
			if (0 < k && !array[k]) {
				array[k] = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	private static Set<Integer> getAllDigits(int n) {
		final Set<Integer> set = new HashSet<>();

		while (0 < n) {
			final int d = n / 10;
			final int k = n - d * 10;
			n = d;
			set.add(k);
		}
		return set;
	}

	public static boolean isAllDigitsDistinctAndPositive(final int n, final int m) {
		if (lengthOfNumber(n) + lengthOfNumber(m) + lengthOfNumber(n * m) != 9) {
			return false;
		}
		final Set<Integer> setN = getAllDigits(n);
		final Set<Integer> setM = getAllDigits(m);
		final Set<Integer> setNM = getAllDigits(n * m);
		setNM.addAll(setN);
		setNM.addAll(setM);
		return setNM.size() == 9;
	}

	private static int lengthOfNumber(final int n) {
		return (int) (Math.log10(n) + 1);
	}
}
