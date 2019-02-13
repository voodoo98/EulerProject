package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution016 {

	public static void main(final String[] args) {

		final BigInteger bigInteger = new BigInteger();
		bigInteger.pow(2, 1000);

		int sum = 0;
		for (int i = 0; i < bigInteger.length(); i++) {
			final int numericValue = Character.getNumericValue(bigInteger.value().charAt(i));
			sum += numericValue;
		}
		System.err.println(sum);
	}

}
