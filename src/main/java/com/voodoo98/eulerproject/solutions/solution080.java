package com.voodoo98.eulerproject.solutions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.polygonalnumber.SquareNumber;
import com.voodoo98.eulerproject.utils.StringUtils;

public class solution080 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		System.err.println(StringUtils.digitSum(countDigits(2).toString().replace(".", ""), 100));
		int sum = 0;
		for (int n = 2; n < 100; n++) {
			if (!SquareNumber.isSquare(n)) {
				final String digits = countDigits(n).toString().replace(".", "");
				sum += StringUtils.digitSum(digits, 100);
			}
		}

		return sum;
	}

	private static BigDecimal countDigits(final int D) {
		final List<Integer> continuedFraction = getContinuedFraction(D);
		final int sqrtD = (int) Math.sqrt(D);
		BigInteger a0 = BigInteger.valueOf(sqrtD);
		final BigInteger a1 = BigInteger.valueOf(continuedFraction.get(0));
		BigInteger p0 = a0;
		BigInteger p1 = p0.multiply(a1).add(BigInteger.ONE);
		BigInteger q0 = BigInteger.ONE;
		BigInteger q1 = a1;
		BigInteger p = p1;
		BigInteger q = q1;
		for (int i = 1; i < 200; i++) {
			a0 = BigInteger.valueOf(continuedFraction.get(i % continuedFraction.size()));
			p = p1.multiply(a0).add(p0);
			p0 = p1;
			p1 = p;
			q = q1.multiply(a0).add(q0);
			q0 = q1;
			q1 = q;
		}
		final BigDecimal pd = new BigDecimal(p);
		final BigDecimal qd = new BigDecimal(q);
		return pd.divide(qd, 200, RoundingMode.CEILING);
	}

	private static List<Integer> getContinuedFraction(final int n) {
		final int sqrtD = (int) Math.sqrt(n);
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
}
