package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.pythagoreantriplet.PythagoreanTriplet;

public class solution009 {

	public static void main(final String[] args) {

		final PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet(3, 4, 5);
		System.out.println(pythagoreanTriplet.isPythagoreanTriplet());

		final PythagoreanTriplet pythagoreanTriplet2 = new PythagoreanTriplet(4, 5, 6);
		System.out.println(pythagoreanTriplet2.isPythagoreanTriplet());

		for (int i = 1; i < 1000; i++) {
			for (int j = i + 1; j < 1000; j++) {
				for (int k = j + 1; k < 1000; k++) {
					final PythagoreanTriplet triplet = new PythagoreanTriplet(i, j, k);
					if (i + j + k == 1000 && triplet.isPythagoreanTriplet()) {
						System.err.println(triplet.getTripletProduct());
					}
				}
			}

		}

	}
}
