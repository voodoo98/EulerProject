package com.voodoo98.eulerproject.poker;

public enum CardValue {

	_2(2),
	_3(3),
	_4(4),
	_5(5),
	_6(6),
	_7(7),
	_8(8),
	_9(9),
	T(10),
	J(11),
	Q(12),
	K(13),
	A(14);

	private final int value;

	private CardValue(final int value) {
		this.value = value;
	}

	public static CardValue parseValue(final int value) {
		CardValue result = null;
		for (final CardValue cardValue : values()) {
			if (cardValue.getValue() == value) {
				result = cardValue;
			}
		}
		return result;
	}

	public static CardValue parse(final String string) {
		CardValue result = null;
		for (final CardValue cardValue : values()) {
			if (cardValue.name().contains(string)) {
				result = cardValue;
			}
		}
		return result;
	}

	public int getValue() {
		return this.value;
	}

}
