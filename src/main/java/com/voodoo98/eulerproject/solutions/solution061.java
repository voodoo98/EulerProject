package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.polygonalnumber.PolygonalNumber;
import com.voodoo98.eulerproject.polygonalnumber.PolygonalNumberFactory;
import com.voodoo98.eulerproject.polygonalnumber.PolygonalType;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution061 {

	private static Map<PolygonalType, long[]> numberHolder;
	private static int sum;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {

		numberHolder = preloadPolygonalNumbers();

		final Permute permute = new Permute(true);
		permute.permute(new int[] { 3, 4, 5, 6, 7, 8 });
		final List<int[]> permutationList = permute.getArrayListResult();
		final int[] numbers = new int[6];
		for (final int[] permutation : permutationList) {
			final List<PolygonalType> polyPermList = generatePolygonalPermutations(permutation);
			for (final long number : numberHolder.get(polyPermList.get(0))) {
				numbers[0] = (int) number;
				checkPolygonalNumber(numbers, polyPermList, 1);
			}
		}

		return sum;
	}

	private static List<PolygonalType> generatePolygonalPermutations(final int[] permutation) {
		final List<PolygonalType> polyPermList = new ArrayList<>();
		Arrays.stream(permutation).forEach(element -> polyPermList.add(PolygonalType.parseFromIndex(element)));
		return polyPermList;
	}

	private static void checkPolygonalNumber(final int[] numbers, final List<PolygonalType> polyPermList, final int index) {
		if (sum == 0) {
			final int length = numbers.length;
			final long[] polygonalNumbers = numberHolder.get(polyPermList.get(index % length));

			final int last2Digits = getLast2Digits(numbers[index - 1]);
			if (index < length) {
				for (final long number : polygonalNumbers) {
					final int first2Digits = getFirst2Digits((int) number);
					if (last2Digits == first2Digits) {
						numbers[index] = (int) number;
						checkPolygonalNumber(numbers, polyPermList, index + 1);
					}
				}
			} else {
				final int first2DigitsOfFirstNumber = getFirst2Digits(numbers[0]);
				if (last2Digits == first2DigitsOfFirstNumber) {
					System.out.println(Arrays.toString(numbers));
					sum = NumberUtils.sumArray(numbers);
				}
			}
		}

	}

	private static Map<PolygonalType, long[]> preloadPolygonalNumbers() {
		final Map<PolygonalType, long[]> map = new HashMap<>();
		for (final PolygonalType type : PolygonalType.values()) {
			final PolygonalNumber number = PolygonalNumberFactory.getInstance(type);
			map.put(type, number.getSubArray(1000, 10000));
		}
		return map;

	}

	private static int getFirst2Digits(final int number) {
		return number / 100;
	}

	private static int getLast2Digits(final int n) {
		return n % 100;
	}
}
