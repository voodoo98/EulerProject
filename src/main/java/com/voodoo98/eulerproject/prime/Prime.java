package com.voodoo98.eulerproject.prime;

public class Prime {

	public static boolean isPrime(final long l) {
		if (l < 0) {
			throw new IllegalArgumentException("Negative number");
		}
		if (l == 0 || l == 1) {
			return false;
		} else if (l == 2) {
			return true;
		} else {
			if (l % 2 == 0) {
				return false;
			}
			for (int i = 3, end = (int) Math.sqrt(l) + 1; i <= end; i += 2) {
				if (l % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
