package com.voodoo98.eulerproject.pandigital;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class PandigitalNumber {

	private final BigInteger bigInteger;

	public PandigitalNumber(final BigInteger bigInteger) {
		this.bigInteger = bigInteger;
	}

	public PandigitalNumber(final String number) {
		this(new BigInteger(number));
	}

	public PandigitalNumber(final long number) {
		this(new BigInteger(number));
	}

	public static boolean isPandigital(long l) {
		int digits = 0;
		int count = 0;
		int tmp;

		for (; l > 0; l /= 10, ++count) {
			if ((tmp = digits) == (digits |= 1 << l - l / 10 * 10 - 1)) {
				return false;
			}
		}

		return digits == (1 << count) - 1;
	}

	public boolean isPandigitalNumber() {
		final int length = this.bigInteger.length();
		final boolean[] array = new boolean[length];
		boolean result = true;
		for (int i = 0; i < length; i++) {
			final int digit = this.bigInteger.getDigit(i);
			if (0 < digit && digit - 1 < length && !array[digit - 1]) {
				array[digit - 1] = true;
			} else {
				result = false;
				break;
			}
		}
		if (result) {
			for (int i = 1; i < length; i++) {
				if (!array[i]) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	public BigInteger getBigInteger() {
		return this.bigInteger;
	}

	@Override
	public String toString() {
		return this.bigInteger.toString();
	}

}
