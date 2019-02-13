package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.utils.MathUtils;

public class solution031 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {
		return MathUtils.findCombinationsCount(200, new int[] { 1, 2, 5, 10, 20, 50, 100, 200 });
	}
}
