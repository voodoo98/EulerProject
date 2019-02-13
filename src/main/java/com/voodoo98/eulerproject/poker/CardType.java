package com.voodoo98.eulerproject.poker;

public enum CardType {

	CLUB("C", "♣"),
	DIAMOND("D", "♦"),
	HEART("H", "♥"),
	SPADE("S", "♠");

	private final String abbriviation;
	private final String sign;

	private CardType(final String abbriviation, final String sign) {
		this.abbriviation = abbriviation;
		this.sign = sign;
	}

	public static CardType parse(final String string) {
		CardType result = null;
		for (final CardType cardType : values()) {
			if (cardType.getAbbriviation().equalsIgnoreCase(string)) {
				result = cardType;
			}
		}
		return result;
	}

	public String getSign() {
		return this.sign;
	}

	public String getAbbriviation() {
		return this.abbriviation;
	}

}
