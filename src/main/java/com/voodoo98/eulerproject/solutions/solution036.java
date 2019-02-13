package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution036 {

	private static final int LIMIT = 1_000_000;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {
		int sum = 0;
		for (int i = 1; i < LIMIT; i++) {
			if (NumberUtils.isPalindrome(i) && NumberUtils.isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		return sum;
	}

}
