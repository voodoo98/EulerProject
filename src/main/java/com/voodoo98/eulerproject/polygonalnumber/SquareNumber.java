package com.voodoo98.eulerproject.polygonalnumber;

public class SquareNumber extends PolygonalNumber {

	static long goodMask = 0;

	static {
		for (int i = 0; i < 64; ++i) {
			goodMask |= Long.MIN_VALUE >>> i * i;
		}
	}

	public final static boolean isSquare(final long n) {
		// This tests if the 6 least significant bits are right.
		// Moving the to be tested bit to the highest position saves us masking.
		long x = n;
		if (goodMask << x >= 0) {
			return false;
		}
		final int numberOfTrailingZeros = Long.numberOfTrailingZeros(x);
		// Each square ends with an even number of zeros.
		if ((numberOfTrailingZeros & 1) != 0) {
			return false;
		}
		x >>= numberOfTrailingZeros;
		// Now x is either 0 or odd.
		// In binary each odd square ends with 001.
		// Postpone the sign test until now; handle zero in the branch.
		if ((x & 7) != 1 | x <= 0) {
			return x == 0;
		}
		// Do it in the classical way.
		// The correctness is not trivial as the conversion from long to double
		// is lossy!
		final long tst = (long) Math.sqrt(x);
		return tst * tst == x;
	}

	public static long getSquare(final long n) {
		return n * n;
	}

	@Override
	protected long formula(final long n) {
		return getSquare(n);
	}

}
