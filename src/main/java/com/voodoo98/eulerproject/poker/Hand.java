package com.voodoo98.eulerproject.poker;

import java.util.Arrays;

public class Hand implements Comparable<Hand> {

	private static final String SEPARATOR = " ";

	private final Card[] cards;

	public Hand(final String[] cardsString) {
		this.cards = new Card[cardsString.length];
		for (int i = 0; i < cardsString.length; i++) {
			this.cards[i] = new Card(cardsString[i]);
		}
		Arrays.sort(this.cards);

	}

	public Hand(final String cardString) {
		this(cardString.split(SEPARATOR));
	}

	public HandResult getValue() {
		final PokerPair pair = this.getPairs();
		final CardValue highCard = this.getHighCardValue(pair);

		if (this.hasRoyalFlush(pair)) {
			return new HandResult(Rank.ROYAL_FLUSH, pair.getCardValue(), highCard);
		}

		if (this.hasStraightFlush()) {
			return new HandResult(Rank.STRAIGHT_FLUSH, pair.getCardValue(), highCard);
		}

		if (this.hasPoker(pair)) {
			return new HandResult(Rank.POKER, pair.getCardValue(), highCard);
		}

		if (this.hasFull(pair)) {
			return new HandResult(Rank.FULL_HOUSE, pair.getCardValue(), highCard);
		}

		if (this.hasFlush()) {
			return new HandResult(Rank.FLUSH, pair.getCardValue(), highCard);
		}

		if (this.hasStraight()) {
			return new HandResult(Rank.STRAIGHT, pair.getCardValue(), highCard);
		}

		if (this.hasDrill(pair)) {
			return new HandResult(Rank.DRILL, pair.getCardValue(), highCard);
		}

		if (this.hasTwoPair(pair)) {
			return new HandResult(Rank.TWO_PAIRS, pair.getCardValue(), highCard);
		}

		if (this.hasPair(pair)) {
			return new HandResult(Rank.ONE_PAIR, pair.getCardValue(), highCard);
		}

		if (this.hasHighCardOnly(pair)) {
			return new HandResult(Rank.HIGH_CARD, pair.getCardValue(), highCard);
		}

		return null;

	}

	private boolean hasHighCardOnly(final PokerPair pair) {
		return pair.getCount() == 1;
	}

	private boolean hasPair(final PokerPair pair) {
		return pair.getCount() == 2;
	}

	private boolean hasTwoPair(final PokerPair pair) {
		return this.hasPair(pair) && pair.getPairCount() == 2;
	}

	private boolean hasDrill(final PokerPair pair) {
		return pair.getCount() == 3;
	}

	private boolean hasStraight() {
		return !this.isAllElementFromSameSuit() && this.isConsecutive();
	}

	private boolean hasFlush() {
		return this.isAllElementFromSameSuit();
	}

	private boolean hasFull(final PokerPair pair) {
		return pair.isFull();
	}

	private boolean hasStraightFlush() {
		return this.isAllElementFromSameSuit() && this.isConsecutive();
	}

	private boolean hasPoker(final PokerPair pair) {
		return pair.getCount() == 4;
	}

	private boolean hasRoyalFlush(final PokerPair pair) {
		return this.hasStraightFlush() && this.getMaxCardValue(pair) == CardValue.A;
	}

	public PokerPair getPairs() {
		final int[] array = new int[CardValue.values().length];
		for (final Card card : this.cards) {
			array[card.getCardValue().getValue() - 2]++;
		}
		final int maxValue = Arrays.stream(array).max().getAsInt();
		int maxIndex = 0;
		int maxCount = 0;
		boolean hasAnotherPair = false;
		for (int j = 0; j < array.length; j++) {
			if (array[j] == maxValue) {
				maxCount++;
			}
			if (array[maxIndex] <= array[j]) {
				maxIndex = j;
			}
			if (array[j] == 2) {
				hasAnotherPair = true;
			}
		}
		final PokerPair pokerPair = new PokerPair(maxIndex, array[maxIndex]);
		pokerPair.setPairCount(maxCount);
		pokerPair.setFull(hasAnotherPair && pokerPair.getCount() == 3);
		return pokerPair;
	}

	private boolean isConsecutive() {
		boolean result = true;
		for (int i = 1; i < this.cards.length; i++) {
			if (this.cards[0].getCardValue().getValue() + i != this.cards[i].getCardValue().getValue()) {
				result = false;
				break;
			}
		}
		return result;
	}

	private boolean isAllElementFromSameSuit() {
		boolean result = true;
		for (int i = 1; i < this.cards.length; i++) {
			if (this.cards[0].getType() != this.cards[i].getType()) {
				result = false;
				break;
			}
		}
		return result;
	}

	private CardValue getHighCardValue(final PokerPair pair) {
		return CardValue.parseValue(Arrays.stream(this.cards).filter(i -> i.getCardValue().getValue() != pair.getCardValue().getValue()).mapToInt(i -> i.getCardValue().getValue()).max().getAsInt());

	}

	private CardValue getMaxCardValue(final PokerPair pair) {
		return CardValue.parseValue(Arrays.stream(this.cards).mapToInt(i -> i.getCardValue().getValue()).max().getAsInt());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(this.cards);
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
		final Hand other = (Hand) obj;
		if (!Arrays.equals(this.cards, other.cards)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + Arrays.toString(this.cards) + "]";
	}

	public boolean lessThan(final Hand o) {
		return this.compareTo(o) < 0;
	}

	public boolean biggerThan(final Hand o) {
		return this.compareTo(o) > 0;
	}

	public boolean same(final Hand o) {
		return this.compareTo(o) == 0;
	}

	@Override
	public int compareTo(final Hand o) {
		return this.getValue().compareTo(o.getValue());
	}

}
