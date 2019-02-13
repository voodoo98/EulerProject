package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.phi.EulerPhiSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution072 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	// https://en.wikipedia.org/wiki/Farey_sequence#Properties
	private static long count() {
		final EulerPhiSieve eulerPhiSieve = new EulerPhiSieve(1_000_001);
		final long[] phiArrays = eulerPhiSieve.count();
		final long Fn = 1 + NumberUtils.sumArray(phiArrays);
		return Fn - 2;
	}

}
