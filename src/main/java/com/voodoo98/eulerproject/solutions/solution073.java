package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.fraction.Fraction;
import com.voodoo98.eulerproject.phi.EulerPhiSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution073 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	// https://en.wikipedia.org/wiki/Farey_sequence#Properties
	private static long count() {
		return farey(12_000);
	}

	private static long farey(final long n) {
		long sum = 0;
		long a = 0, b = 1, c = 1, d = n;
		while (c < n) {
			final long k = (n + b) / d;
			final long prevc = c;
			final long prevd = d;
			c = k * c - a;
			d = k * d - b;
			a = prevc;
			b = prevd;
			final double value = (double) a / b;
			if (1d / 3 < value && value < 1d / 2) {
				sum++;
			} else if (1d / 3 < value) {
				break;
			}
		}
		return sum;
	}
}
