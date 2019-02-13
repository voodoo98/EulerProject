package com.voodoo98.eulerproject.fraction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortedFractionList extends PriorityQueue<Fraction> implements Comparator<Fraction> {

	private static final long serialVersionUID = 8095283130864983771L;

	@Override
	public int compare(final Fraction o1, final Fraction o2) {
		return o1.compareTo(o2);
	}

	@Override
	public String toString() {
		final Object[] array = this.toArray();
		Arrays.sort(array);
		return Arrays.toString(array);
	}

}
