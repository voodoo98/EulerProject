package com.voodoo98.eulerproject.solutions;

public class solution078 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		long ret = 0;
		for (int limit = 1;; limit *= 2) {
			final int result = findCombinationsCount(limit);
			if (result != 0) {
				ret = result;
				break;
			}
		}
		return ret;
	}

	public static int findCombinationsCount(final int n) {
		final int dp[] = new int[n];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				dp[j] = (dp[j] + dp[j - i]) % 1_000_000;
			}
		}
		for (int i = 0; i < n; i++) {
			if (dp[i] == 0) {
				return i;
			}
		}
		return 0;
	}

}
