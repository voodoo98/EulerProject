package com.voodoo98.eulerproject.solutions;

import java.util.HashSet;
import java.util.Set;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution029 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		final int n = 100;

		final BigInteger[] array = new BigInteger[n - 1];
		for (int i = 0; i < n - 1; i++) {
			array[i] = new BigInteger(i + 2);
		}
		final Set<BigInteger> set = new HashSet<>();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				array[j] = array[j].multiply(j + 2);
				set.add(array[j]);
			}
		}
		System.err.println("Result: " + set.size());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

}
