package com.voodoo98.eulerproject.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.voodoo98.eulerproject.pythagoreantriplet.PythagoreanTriplet;

public class solution075 {

	private static final int LIMIT = 1_500_000;

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final Multiset<Integer> perimeterBag = HashMultiset.create();
		final Set<PythagoreanTriplet> tripleSet = new HashSet<>();
		final double loopLength = Math.sqrt(LIMIT);
		for (int s = 1; s < loopLength; s++) {
			for (int t = s + 1; t < loopLength - s; t++) {
				final long xt = t * t - s * s;
				final long yt = 2 * s * t;
				final long zt = t * t + s * s;
				final long x = getMin(xt, yt, zt);
				final long z = getMax(xt, yt, zt);
				final long y = getMiddle(new long[] { xt, yt, zt }, x, z);
				int d = 0;
				long a;
				long b;
				long c = 0;
				while (c <= LIMIT) {
					d++;
					a = x * d;
					b = y * d;
					c = z * d;
					if (isPerimeterInRange(a, b, c)) {
						final PythagoreanTriplet e = new PythagoreanTriplet(a, b, c);
						if (!tripleSet.contains(e)) {
							tripleSet.add(e);
							perimeterBag.add((int) (a + b + c));
						}
					}
				}
			}
		}

		return perimeterBag.stream().filter(i -> perimeterBag.count(i) == 1).mapToInt(i -> perimeterBag.count(i)).sum();
	}

	private static boolean isPerimeterInRange(final long x, final long y, final long z) {
		return x + y + z <= LIMIT;
	}

	private static long getMin(final long... arr) {
		return Arrays.stream(arr).min().getAsLong();
	}

	private static long getMax(final long... arr) {
		return Arrays.stream(arr).max().getAsLong();
	}

	private static long getMiddle(final long[] arr, final long min, final long max) {
		for (final long element : arr) {
			if (element != min && element != max) {
				return element;
			}
		}
		return arr[0];
	}

}
