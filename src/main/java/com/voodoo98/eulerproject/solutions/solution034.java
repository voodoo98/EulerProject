package com.voodoo98.eulerproject.solutions;

public class solution034 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final int[] factArray = new int[10];
		factArray[0] = 1;
		for (int i = 1; i < factArray.length; i++) {
			factArray[i] = factArray[i - 1] * i;
		}

		long sumAll = 0;
		for (int n = 3; n < 50000; n++) {
			long sum = 0;
			final String number = String.valueOf(n);
			for (int d = 0; d < number.length(); d++) {
				sum += factArray[number.charAt(d) - 48];
			}
			if (sum == n) {
				sumAll += n;
			}
		}
		return sumAll;
	}

}
