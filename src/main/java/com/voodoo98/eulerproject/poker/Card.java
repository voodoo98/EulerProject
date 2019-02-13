package com.voodoo98.eulerproject.poker;

public class Card implements Comparable<Card> {

	private final CardValue value;
	private final CardType type;

	public Card(final CardType type, final CardValue value) {
		this.type = type;
		this.value = value;
	}

	public Card(final String cardString) {
		this.value = CardValue.parse(String.valueOf(cardString.charAt(0)));
		this.type = CardType.parse(String.valueOf(cardString.charAt(1)));
	}

	public CardValue getCardValue() {
		return this.value;
	}

	public CardType getType() {
		return this.type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
		result = prime * result + (this.value == null ? 0 : this.value.hashCode());
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
		final Card other = (Card) obj;
		if (this.type != other.type) {
			return false;
		}
		if (this.value != other.value) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(final Card o) {
		return this.getCardValue().compareTo(o.getCardValue());
	}

	@Override
	public String toString() {
		return "Card [value=" + this.value + ", type=" + this.type + "]";
	}

}
