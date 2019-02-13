package com.voodoo98.eulerproject.perfectnumber;

import com.voodoo98.eulerproject.divisors.ProperDivisor;

public class PerfectNumber {

	private final long number;

	public PerfectNumber(final long number) {
		this.number = number;
	}

	public static boolean isPerfect(final long number) {
		return number == ProperDivisor.getSumOfDivisors(number);
	}

	public static boolean isDeficient(final long number) {
		return ProperDivisor.getSumOfDivisors(number) < number;
	}

	public static boolean isAbundant(final long number) {
		return number < ProperDivisor.getSumOfDivisors(number);
	}

	public boolean isPerfectNumber() {
		return this.number == ProperDivisor.getSumOfDivisors(this.number);
	}
}
