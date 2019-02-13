package com.voodoo98.eulerproject.utils;

import java.math.BigInteger;

public class BigIntegerUtils {

	private BigIntegerUtils() {
	}

	public static BigInteger sqrt(final BigInteger number) {
		if (number.signum() == -1) {
			throw new ArithmeticException("We can only calculate the square root of positive numbers.");
		}
		return newtonIteration(number, BigInteger.ONE);
	}

	private static BigInteger newtonIteration(final BigInteger n, final BigInteger x0) {
		final BigInteger x1 = n.divide(x0).add(x0).shiftRight(1);
		return x0.equals(x1) || x0.equals(x1.subtract(BigInteger.ONE)) ? x0 : newtonIteration(n, x1);
	}

}
