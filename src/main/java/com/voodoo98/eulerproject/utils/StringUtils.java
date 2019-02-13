package com.voodoo98.eulerproject.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

	private StringUtils() {
	}

	public static String[] parseWordsFromResource(final String fileName) throws IOException {
		final List<String> list = Files.readAllLines(Paths.get("resources/" + fileName));
		return list.get(0).replaceAll("\"", "").split(",");

	}

	public static String[] parseSortWordsFromResource(final String fileName) throws IOException {
		final String[] words = parseWordsFromResource(fileName);
		Arrays.sort(words);
		return words;
	}

	public static int digitSum(final String string) {
		return digitSum(string, string.length());
	}

	public static int digitSum(final String string, final int length) {
		int sum = 0;
		final String s = string.toString();
		for (int i = 0; i < length; i++) {
			sum += s.charAt(i) - '0';
		}
		return sum;
	}

	public static boolean hasSameChar(final String str1, final String str2) {
		for (final char c : str1.toCharArray()) {
			if (str2.indexOf(c) < 0) {
				return false;
			}
		}
		for (final char c : str2.toCharArray()) {
			if (str1.indexOf(c) < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean arePermutatedStrings(final String str1, final String str2) {

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		final char[] a = str1.toCharArray();
		final char[] b = str2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		return Arrays.equals(a, b);
	}

	public static String removeLeadingZeros(final String s) {
		return s != null ? s.replaceFirst("^0+(?!$)", "") : null;
	}

	public static boolean isDecimal(final String str) {
		return str != null ? str.matches("\\d+") : false;
	}

	public static boolean isNumeric(final String str) {
		return str != null ? str.matches("-?\\d+(\\.\\d+)?") : false;
	}

	public static int[] stringToIntArray(final String str) {
		if (str != null && isDecimal(str)) {
			return Arrays.stream(str.split("")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		} else {
			return new int[] {};
		}
	}

	public static String intArrayToString(final int[] array) {
		final StringBuilder sb = new StringBuilder();
		for (final int element : array) {
			sb.append(element);
		}
		return sb.toString();
	}

}
