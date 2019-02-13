package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.ErasthotenesSieve;

public class solution047 {

	private static final int DISTINCT_PRIME_FACTOR = 4;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final int limit = 1_000_000;
		final ErasthotenesSieve ps = new ErasthotenesSieve(limit);
		ps.count();
		int result = 0;
		for (int i = 1; i < limit; i++) {
			if (checkElement(ps, i) && checkElement(ps, i + 1) && checkElement(ps, i + 2) && checkElement(ps, i + 3)) {
				result = i;
				break;
			}
		}
		return result;
	}

	private static boolean checkElement(final ErasthotenesSieve es, final int i) {
		return es.getCount(i) == DISTINCT_PRIME_FACTOR;
	}
}
