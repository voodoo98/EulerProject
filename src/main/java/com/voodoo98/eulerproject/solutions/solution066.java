package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.biginteger.BigInteger;
import com.voodoo98.eulerproject.polygonalnumber.SquareNumber;

public class solution066 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	// http://mathworld.wolfram.com/PellEquation.html
	private static int count() {
		int maxD = 0;
		BigInteger max = BigInteger.ZERO;
		for (int D = 2; D < 1000; D++) {
			if (!SquareNumber.isSquare(D)) {
				final int sqrtD = (int) Math.sqrt(D);
				final List<Integer> continuedFractionD = getContinuedFraction(D, sqrtD);
				final long a0 = sqrtD;
				final int a1 = continuedFractionD.get(0);
				BigInteger p0 = new BigInteger(a0);
				BigInteger p1 = p0.multiply(a1).add(1);
				BigInteger q0 = BigInteger.ONE;
				BigInteger q1 = new BigInteger(a1);
				int i = 0;
				BigInteger p = p1;
				BigInteger q = q1;
				while (!isDiophantine(p, q, D)) {
					i++;
					final int a = continuedFractionD.get(i % continuedFractionD.size());
					p = p1.multiply(a).add(p0);
					p0 = p1;
					p1 = p;
					q = q1.multiply(a).add(q0);
					q0 = q1;
					q1 = q;
				}
				if (max.lessThan(p)) {
					max = p;
					maxD = D;
				}
			}
		}
		return maxD;
	}

	private static List<Integer> getContinuedFraction(final int n, final int sqrtD) {
		final List<Integer> result = new ArrayList<>();
		int m = 0;
		int d = 1;
		int a = sqrtD;
		do {
			m = d * a - m;
			d = (n - m * m) / d;
			a = (sqrtD + m) / d;
			result.add(a);
		} while (a != 2 * sqrtD);
		return result;
	}

	private static boolean isDiophantine(final BigInteger x, final BigInteger y, final int D) {
		return x.pow(2).equals(y.pow(2).multiply(D).add(BigInteger.ONE));
	}

}
