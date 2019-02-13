package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution033 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count() + " == 1 / 100");
		System.err.println("Result: 100");
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static double count() {
		double sumDenominator = 1;
		for (int i = 1; i < 100; i++) {
			for (int j = 10; j < i; j++) {
				final int denominator = checkTrivialFraction(j, i);
				if (0 < denominator) {
					final double d = (double) j / i;
					sumDenominator *= d;
				}
			}
		}

		return sumDenominator;
	}

	private static int checkTrivialFraction(final int n, final int m) {
		final double div = (double) n / m;
		final int[] nDigits = NumberUtils.longConvertToArray(n);
		final int[] mDigits = NumberUtils.longConvertToArray(m);
		int nPos = -1;
		int mPos = -1;
		for (int i = 0; i < nDigits.length; i++) {
			for (int j = 0; j < mDigits.length; j++) {
				if (nDigits[i] == mDigits[j]) {
					nPos = i;
					mPos = j;
				}
			}
		}

		if (-1 < nPos && -1 < mPos && nPos != mPos) {
			final double trivDiv = (double) nDigits[1 - nPos] / mDigits[1 - mPos];
			return div == trivDiv ? mDigits[1 - mPos] : -1;
		} else {
			return -1;
		}
	}

}
