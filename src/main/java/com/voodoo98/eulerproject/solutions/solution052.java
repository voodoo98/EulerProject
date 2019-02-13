package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.permutation.Permute;

public class solution052 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		for (int x = 100000; x < 1_000_000; x++) {
			if (Permute.arePermutatedPairs(x, 2 * x)) {
				if (Permute.arePermutatedPairs(x, 3 * x)) {
					if (Permute.arePermutatedPairs(x, 4 * x)) {
						if (Permute.arePermutatedPairs(x, 5 * x)) {
							if (Permute.arePermutatedPairs(x, 6 * x)) {
								return x;
							}
						}
					}
				}
			}
		}
		return 0;
	}
}
