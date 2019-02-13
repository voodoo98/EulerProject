package com.voodoo98.eulerproject.solutions;

import java.util.Collections;

import com.voodoo98.eulerproject.permutation.Permute;

public class solution024 {

	public static void main(final String[] args) {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() {
		final Permute permute = new Permute();
		permute.permute(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.sort(permute.getResultList());
		return permute.getResultList().get(999999);
	}
}
