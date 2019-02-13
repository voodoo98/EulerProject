package com.voodoo98.eulerproject.biginteger;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class BigInteger implements Comparable<BigInteger> {

	public final static BigInteger ZERO = new BigInteger(0);
	public final static BigInteger ONE = new BigInteger(1);
	public final static BigInteger TWO = new BigInteger(2);

	private String number;

	public BigInteger() {
		this(0L);
	}

	public BigInteger(final BigInteger number) {
		this(String.valueOf(number.value()));
	}

	public BigInteger(final long number) {
		this(String.valueOf(number));
	}

	public BigInteger(final String number) {
		this.number = number;
	}

	public BigInteger(final int[] array) {
		this(NumberUtils.arrayConvertInt(array));
	}

	public static BigInteger createInstance(final int value) {
		return new BigInteger(value);
	}

	public BigInteger add(final String numberA, final String numberB) {
		final StringBuilder result = new StringBuilder();
		final StringBuilder numA = new StringBuilder(numberA).reverse();
		final StringBuilder numB = new StringBuilder(numberB).reverse();

		int numADigit = 0;
		int numBDigit = 0;
		int remainValue = 0;
		int sum = 0;
		final int maxLength = Math.max(numA.length(), numB.length());
		for (int i = 0; i < maxLength; i++) {
			numADigit = this.parseDigit(numA, i);
			numBDigit = this.parseDigit(numB, i);
			sum = remainValue + numADigit + numBDigit;
			final int digit = sum % 10;
			remainValue = sum / 10;
			result.append(digit);
		}
		if (0 < remainValue) {
			result.append(remainValue);
		}
		return new BigInteger(result.reverse().toString());

	}

	public BigInteger add(final long x) {
		return this.add(this.value(), String.valueOf(x));
	}

	public BigInteger add(final String xString) {
		return this.add(this.value(), xString);
	}

	public BigInteger add(final BigInteger bigInteger) {
		return this.add(this.value(), bigInteger.value());
	}

	public BigInteger add(final long x, final long y) {
		return this.add(String.valueOf(x), String.valueOf(y));
	}

	public BigInteger add(final BigInteger bigIntegerA, final BigInteger bigIntegerB) {
		return bigIntegerA.add(bigIntegerA.value(), bigIntegerB.value());
	}

	public BigInteger multiply(final BigInteger bigInteger) {
		return this.multiply(String.valueOf(bigInteger.value()));
	}

	public BigInteger multiply(final long value) {
		return this.multiply(String.valueOf(value));
	}

	public BigInteger multiply(final String xString) {
		return this.multiply(this.number, xString);
	}

	public BigInteger multiply(final long x, final int y) {
		return this.multiply(String.valueOf(x), String.valueOf(y));
	}

	public BigInteger multiply(final String num, final String multiply) {
		final StringBuilder number = new StringBuilder(num).reverse();
		final StringBuilder mul = new StringBuilder(multiply).reverse();

		BigInteger sum = new BigInteger();
		for (int j = 0; j < mul.length(); j++) {
			final int multiplyDigit = this.parseDigit(mul, j);
			for (int i = 0; i < number.length(); i++) {
				final int numberDigit = this.parseDigit(number, i);
				final String paddingWith0 = NumberUtils.paddingNotNullNumberWith0(numberDigit * multiplyDigit, i + j);
				sum = sum.add(paddingWith0);
			}
		}
		return sum;
	}

	// public BigInteger divide(final String number, final String divisor) {
	// final StringBuilder num = new StringBuilder(number).reverse();
	// final StringBuilder div = new StringBuilder(divisor).reverse();
	// long sum = number / div
	//
	// return null;
	// }

	public BigInteger divide(final int number, final int divisor) {
		final StringBuilder result = new StringBuilder(10000);
		int num = number;
		int counter = 0;
		int div = 0;
		int mod = 1;
		while (counter++ < 2000 && 0 < mod) {
			div = num / divisor;
			mod = num % divisor;
			result.append(div);
			if (counter == 1 && 0 < mod) {
				result.append(".");
			}
			num = 10 * mod;
		}
		return new BigInteger(result.toString());
	}

	public BigInteger pow(final int number, final int n) {
		BigInteger bigInteger = new BigInteger(1);
		for (int i = 1; i <= n; i++) {
			bigInteger = bigInteger.multiply(number);
		}
		return bigInteger;
	}

	public BigInteger pow(final String number, final int n) {
		BigInteger bigInteger = new BigInteger(1);
		for (int i = 1; i <= n; i++) {
			bigInteger = bigInteger.multiply(number);
		}
		return bigInteger;
	}

	public BigInteger pow(final BigInteger bigInteger, final int n) {
		BigInteger bigInt = new BigInteger(1);
		for (int i = 1; i <= n; i++) {
			bigInt = bigInt.multiply(bigInteger.value());
		}
		return bigInt;
	}

	public BigInteger pow(final int n) {
		return this.pow(this.number, n);
	}

	public BigInteger factorial() {
		return this.factorial(Long.parseLong(this.number));
	}

	public BigInteger factorial(final long n) {
		BigInteger bigInteger = new BigInteger(1);
		for (int i = 2; i <= n; i++) {
			bigInteger = bigInteger.multiply(i);
		}
		return bigInteger;
	}

	public int getDigit(final int i) {
		return this.value().charAt(i) - '0';
	}

	public long sumDigits() {
		long sum = 0;
		for (int j = 0; j < this.length(); j++) {
			sum += this.getDigit(j);
		}
		return sum;
	}

	public String value() {
		return this.number;
	}

	public void setNumber(final BigInteger bigInteger) {
		this.setNumber(bigInteger.value());
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public void setNumber(final long number) {
		this.number = String.valueOf(number);
	}

	public int length() {
		return this.value().length();
	}

	private int parseDigit(final CharSequence number, final int index) {
		return index < number.length() ? Integer.parseInt(number.charAt(index) + "") : 0;
	}

	public String reverse() {
		return new StringBuilder(this.number).reverse().toString();
	}

	public boolean isPalindrome() {
		return this.number.equals(this.reverse());
	}

	public boolean lessThan(final BigInteger number) {
		return 0 < this.compareTo(number);
	}

	public boolean greaterThan(final BigInteger number) {
		return this.compareTo(number) < 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.number == null ? 0 : this.number.hashCode());
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
		final BigInteger other = (BigInteger) obj;
		if (this.number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!this.number.equals(other.number)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.value();
	}

	@Override
	public int compareTo(final BigInteger other) {
		final String otherString = other.value();
		final String thisString = this.value();

		if (otherString.length() < thisString.length()) {
			return -1;
		} else if (thisString.length() < otherString.length()) {
			return 1;
		} else {
			for (int i = 0; i < this.length(); i++) {
				if (other.getDigit(i) < this.getDigit(i)) {
					return -1;
				} else if (this.getDigit(i) < other.getDigit(i)) {
					return 1;
				}
			}
		}
		return 0;
	}

}
