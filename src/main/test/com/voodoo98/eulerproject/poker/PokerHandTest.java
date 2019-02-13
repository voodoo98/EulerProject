package com.voodoo98.eulerproject.poker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PokerHandTest {

	@Test
	public void checkHighCard() {
		final Hand hand = new Hand("4H 5C 6H 7H AH");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.HIGH_CARD);
		Assert.assertEquals(result.getCardValue(), CardValue.A);
	}

	@Test
	public void checkOnePair() {
		final Hand hand = new Hand("4H 5C 7H 7H AH");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.ONE_PAIR);
		Assert.assertEquals(result.getCardValue(), CardValue._7);
		Assert.assertEquals(result.getHighCard(), CardValue.A);
	}

	@Test
	public void checkTwoPair() {
		final Hand hand = new Hand("5H 5C 7H 7H JH");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.TWO_PAIRS);
		Assert.assertEquals(result.getCardValue(), CardValue._7);
		Assert.assertEquals(result.getHighCard(), CardValue.J);
	}

	@Test
	public void checkDrill() {
		final Hand hand = new Hand("KH KC 7H 5H KH");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.DRILL);
		Assert.assertEquals(result.getCardValue(), CardValue.K);
	}

	@Test
	public void checkStraight() {
		final Hand hand = new Hand("TH JC QH KH 9H");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.STRAIGHT);
		Assert.assertEquals(result.getCardValue(), CardValue.K);
	}

	@Test
	public void checkStraightFlush() {
		final Hand hand = new Hand("2H 3H 5H 6H 4H");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.STRAIGHT_FLUSH);
		Assert.assertEquals(result.getCardValue(), CardValue._6);
	}

	@Test
	public void checkFullHouse() {
		final Hand hand = new Hand("5H 5C JH JD JS");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.FULL_HOUSE);
		Assert.assertEquals(result.getCardValue(), CardValue.J);
	}

	@Test
	public void checkPoker() {
		final Hand hand = new Hand("QH QC QS QD 2H");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.POKER);
		Assert.assertEquals(result.getCardValue(), CardValue.Q);
	}

	@Test
	public void checkRoyalFlush() {
		final Hand hand = new Hand("TD JD QD KD AD");
		final HandResult result = hand.getValue();
		Assert.assertEquals(result.getRank(), Rank.ROYAL_FLUSH);
		Assert.assertEquals(result.getCardValue(), CardValue.A);
	}

}
