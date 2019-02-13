package com.voodoo98.eulerproject.divisors;

public class ProperDivisor {

	private final long number;

	public ProperDivisor(final long number) {
		this.number = number;

	}

	public ProperDivisorList getDivisorList() {
		final ProperDivisorList result = new ProperDivisorList();
		for (int i = 1; i <= this.number / 2; i++) {
			if (this.number % i == 0) {
				result.add((long) i);
			}
		}
		return result;
	}

	public static long getNumberOfDivisors(final long nr) {
		int divisors = 0;
		final int sqrt = (int) Math.sqrt(nr);
		for (int i = 1; i <= sqrt; i++) {
			if (nr % i == 0) {
				divisors += 2;
			}
		}
		if (sqrt * sqrt == nr) {
			divisors--;
		}
		return divisors;
	}

	public static long getSumOfDivisors(final long nr) {
		int divisorsSum = 0;
		for (int i = 1; i <= nr / 2; i++) {
			if (nr % i == 0) {
				divisorsSum += i;
			}
		}
		return divisorsSum;
	}

	public long getNumber() {
		return this.number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.number ^ this.number >>> 32);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final ProperDivisor other = (ProperDivisor) obj;
		if (this.number != other.number) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProperDivisor [number=" + this.number + "]";
	}

}
