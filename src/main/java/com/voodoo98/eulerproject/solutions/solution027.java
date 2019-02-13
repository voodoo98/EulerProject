package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution027 {

	private static final int LIMIT = 1000;

	public static void main(final String[] args) {
		final PrimeSieve primeSieve = new PrimeSieve(20000);
		primeSieve.count();
		int max = 0;
		int maxProduct = 0;
		for (int a = -LIMIT + 1; a < LIMIT; a++) {
			for (int b = -LIMIT + 1; b < LIMIT; b++) {
				int n = 0;
				while (primeSieve.isPrime(eulerQuadraticFormula(n, a, b))) {
					n++;
				}
				if (max < n) {
					max = n;
					maxProduct = a * b;
				}
			}
		}
		System.err.println(maxProduct);
	}

	private static int eulerQuadraticFormula(final int n, final int a, final int b) {
		return n * n + a * n + b;
	}

}
