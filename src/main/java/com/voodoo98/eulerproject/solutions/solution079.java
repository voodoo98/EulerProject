package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class solution079 {

	public static void main(final String[] args) throws IOException {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() throws IOException {
		final List<String> readAllLines = Files.readAllLines(Paths.get("resources/p079_keylog.txt"));
		final Set<String> set = new TreeSet<>(readAllLines);
		int n = getMinValue(set);
		while (true) {
			if (matching(set, n++)) {
				return n - 1;
			}
		}
	}

	private static int getMinValue(final Set<String> set) {
		final Set<Integer> digitSet = new TreeSet<>();
		for (final String key : set) {
			for (int i = 0; i < 3; i++) {
				final int digit = getDigit(key, i);
				digitSet.add(digit);
			}
		}
		final StringBuilder sb = new StringBuilder();
		for (final Integer digit : digitSet) {
			sb.append(digit);
		}
		String numberString = sb.toString();
		if (numberString.startsWith("0")) {
			numberString = numberString.substring(1, numberString.length()) + "0";
		}
		return Integer.parseInt(numberString);
	}

	private static boolean matching(final Set<String> set, final int i) {
		boolean result = true;
		for (final String key : set) {
			final int digit1 = getDigit(key, 0);
			final int digit2 = getDigit(key, 1);
			final int digit3 = getDigit(key, 2);
			final String number = String.valueOf(i);
			final int indexOfDigit1 = number.indexOf(Character.forDigit(digit1, 10));
			final int indexOfDigit2 = number.indexOf(Character.forDigit(digit2, 10));
			final int indexOfDigit3 = number.indexOf(Character.forDigit(digit3, 10));
			if (indexOfDigit1 == -1 || indexOfDigit2 == -1 || indexOfDigit3 == -1 || !(indexOfDigit1 < indexOfDigit2 && indexOfDigit2 < indexOfDigit3)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static int getDigit(final String number, final int digit) {
		return Character.getNumericValue(number.charAt(digit));
	}

}
