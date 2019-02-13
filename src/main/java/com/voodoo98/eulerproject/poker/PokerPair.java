package com.voodoo98.eulerproject.poker;

public class PokerPair {

	private final CardValue value;
	private final int count;
	private int pairCount;
	private boolean full;

	public PokerPair(final int value, final int count) {
		this.value = CardValue.values()[value];
		this.count = count;
	}

	public PokerPair(final CardValue type, final int count) {
		this.value = type;
		this.count = count;
	}

	public CardValue getCardValue() {
		return this.value;
	}

	public int getCount() {
		return this.count;
	}

	public int getPairCount() {
		return this.pairCount;
	}

	public void setPairCount(final int pairCount) {
		this.pairCount = pairCount;
	}

	public boolean isFull() {
		return this.full;
	}

	public void setFull(final boolean hasFull) {
		this.full = hasFull;
	}

	@Override
	public String toString() {
		return "PokerPair [value=" + this.value + ", count=" + this.count + ", pairCount=" + this.pairCount + "]";
	}

}
