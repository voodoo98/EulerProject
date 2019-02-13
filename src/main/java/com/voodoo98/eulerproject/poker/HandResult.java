package com.voodoo98.eulerproject.poker;

public class HandResult implements Comparable<HandResult> {

	private final Rank rank;
	private final CardValue cardValue;
	private final CardValue highCard;

	public HandResult(final Rank rank, final CardValue cardValue, final CardValue highCard) {
		this.rank = rank;
		this.cardValue = cardValue;
		this.highCard = highCard;
	}

	public Rank getRank() {
		return this.rank;
	}

	public CardValue getCardValue() {
		return this.cardValue;
	}

	public CardValue getHighCard() {
		return this.highCard;
	}

	@Override
	public String toString() {
		return "HandResult [rank=" + this.rank + ", cardValue=" + this.cardValue + ", highCard=" + this.highCard + "]";
	}

	@Override
	public int compareTo(final HandResult o) {
		int result = 0;
		final int rankCompare = this.rank.compareTo(o.getRank());
		if (rankCompare == 0) {
			final int cardValueCompare = this.cardValue.compareTo(o.cardValue);
			if (cardValueCompare == 0) {
				result = this.highCard.compareTo(o.getHighCard());
			} else {
				result = cardValueCompare;
			}
		} else {
			result = rankCompare;
		}
		return result;
	}

}
