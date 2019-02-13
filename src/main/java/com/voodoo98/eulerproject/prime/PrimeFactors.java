package com.voodoo98.eulerproject.prime;

import java.util.ArrayList;

public class PrimeFactors extends ArrayList<Long> {

	private static final long serialVersionUID = -6031661078579167618L;

	public PrimeFactors() {

	}

	public long getMultipliedValue() {
		long result = 1;
		for (final Long factor : this) {
			result *= factor;
		}
		return result;
	}

}
