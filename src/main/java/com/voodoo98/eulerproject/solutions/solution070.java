package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.phi.EulerPhiSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution070 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final int limit = 10_000_000;
		final EulerPhiSieve eulerPhiSieve = new EulerPhiSieve(limit);
		final long[] array = eulerPhiSieve.count();
		double min = Double.MAX_VALUE;
		int minN = 0;
		for (int n = 2; n < limit; n++) {
			final long phi = array[n];
			final int length = NumberUtils.lengthOfNumber(n);
			if (length == NumberUtils.lengthOfNumber(phi) && Permute.arePermutatedPairs(n, phi)) {
				final double nphin = (double) n / phi;
				if (nphin < min) {
					min = nphin;
					minN = n;
				}
			}
		}
		return minN;
	}

}