package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution004 {

	public static void main(final String[] args) {

		int max = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				final int multiply = i * j;
				if (NumberUtils.isPalindrome(multiply) && max < multiply) {
					max = multiply;
				}
			}
		}
		System.err.println(max);
	}
}
