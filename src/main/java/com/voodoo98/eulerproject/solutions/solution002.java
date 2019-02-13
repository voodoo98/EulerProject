package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.fibonacci.Fibonacci;

public class solution002 {

	private static final long BORDER_VALUE = 4000000;

	public static void main(final String[] args) {
		final Fibonacci fibonacci = new Fibonacci(1, 2);
		long sum = fibonacci.getSecond();
		while (fibonacci.getSecond() < BORDER_VALUE) {
			final long count = fibonacci.count();
			sum += count % 2 == 0 ? count : 0;
		}
		System.out.println(sum);
	}
}
