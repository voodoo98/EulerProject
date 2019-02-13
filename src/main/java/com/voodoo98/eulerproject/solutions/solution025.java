package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.fibonacci.FibonacciBigInteger;

public class solution025 {

	public static void main(final String[] args) {

		final FibonacciBigInteger fib = new FibonacciBigInteger();
		int n = 2;
		while (fib.getFibonacci().length() < 1000) {
			fib.count();
			n++;
		}
		System.err.println("Result:" + n);
	}
}
