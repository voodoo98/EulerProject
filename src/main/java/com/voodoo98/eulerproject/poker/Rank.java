package com.voodoo98.eulerproject.poker;

public enum Rank {

	HIGH_CARD(1),
	ONE_PAIR(2),
	TWO_PAIRS(3),
	DRILL(4),
	STRAIGHT(5),
	FLUSH(6),
	FULL_HOUSE(7),
	POKER(8),
	STRAIGHT_FLUSH(9),
	ROYAL_FLUSH(10);

	private final int value;

	private Rank(final int value) {
		this.value = value;

	}

	public int value() {
		return this.value;
	}
}
