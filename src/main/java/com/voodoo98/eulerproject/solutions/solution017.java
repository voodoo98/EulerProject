package com.voodoo98.eulerproject.solutions;

import java.util.Arrays;
import java.util.List;

public class solution017 {

	private static final String AND = "and";
	private static final String THOUSAND = "onethousand";
	private static final String HUNDRED = "hundred";
	private static final List<String> ones = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
	private static final List<String> teens = Arrays.asList("ten", "eleven", "twelwe", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
	private static final List<String> tens = Arrays.asList("ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");

	public static void main(final String[] args) {

		int sum = 0;
		for (int i = 1; i < 1001; i++) {
			final String convert = convert(i);
			System.err.println(convert);
			sum += convert.length();
		}
		System.err.println("Result: " + sum);
	}

	private static String convert(final int number) {
		if (number == 1000) {
			return THOUSAND;
		}

		if (100 <= number) {
			final int hundred = number / 100;
			final int ten = number % 100;
			final String separator = ten == 0 ? "" : AND;
			return convert(hundred) + HUNDRED + separator + convert(ten);
		}

		if (number % 10 == 0 && 0 < number) {
			return tens.get(number / 10 - 1);
		}

		if (20 <= number && number < 100) {
			final int ten = number / 10;
			final int one = number % 10;
			return tens.get(ten - 1) + convert(one);
		}

		if (10 <= number && number < 20) {
			return teens.get(number - 10);
		}

		if (0 < number && number < 10) {
			return ones.get(number - 1);
		}
		return "";
	}

}
