package com.voodoo98.eulerproject.utils;

public class MathUtils {

	public static long nchoosek(final int N, final int K) {
		long ret = 1;
		for (int k = 0; k < K; k++) {
			ret = ret * (N - k) / (k + 1);
		}
		return ret;
	}

	public static long factorial(final long n) {
		long x = 1;
		long y = 1;
		for (long i = 1; i <= n; i++) {
			y = x * i;
			x = y;
		}
		return y;
	}

	public static double logbn(final long b, final long d) {
		return Math.log(d) / Math.log(b);
	}

	public static boolean isRounded(final double d) {
		final double faultTolerance = 0.0000000001;
		final long lng = (long) d;
		return Math.abs(lng - d) < faultTolerance;
	}

	// https://en.wikipedia.org/wiki/Greatest_common_divisor
	public static long gcd(final long l, final long number) {
		return number == 0 ? l : gcd(number, l % number);
	}

	public static long lcm(final long a, final long b) {
		return a * (b / gcd(a, b));
	}

	public static boolean areCoprimes(final long a, final long b) {
		return gcd(a, b) == 1;
	}

	public static int findCombinationsCount(final int sum, final int vals[]) {
		if (sum < 0 || vals == null || vals.length == 0) {
			return 0;
		}

		final int dp[] = new int[sum + 1];
		dp[0] = 1;
		for (final int val : vals) {
			for (int j = val; j <= sum; ++j) {
				dp[j] += dp[j - val];
			}
		}
		return dp[sum];
	}

}
