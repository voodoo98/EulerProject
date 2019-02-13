package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.magicgon.MagicMatrix5gon;

public class solution068 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		return new MagicMatrix5gon().countMax();
	}

}
