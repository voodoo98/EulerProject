package com.voodoo98.eulerproject.solutions;

import static org.bitbucket.dollar.Dollar.*;

public class solution076 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {

		final int total = 100;
		final Integer[] elements = $(1, 100).toArray();
		final int[][] ways = new int[elements.length + 1][total + 1];
		ways[0][0] = 1;
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j <= total; j++) {
				ways[i + 1][j] = ways[i][j] + (elements[i] <= j ? ways[i + 1][j - elements[i]] : 0);
			}
		}
		return ways[elements.length][total];
	}

}
