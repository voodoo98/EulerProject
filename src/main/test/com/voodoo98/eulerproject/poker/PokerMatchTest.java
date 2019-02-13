package com.voodoo98.eulerproject.poker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PokerMatchTest {

    @Test
    public void checkHandEquality() {
        final Hand hand1 = new Hand("4H 5C 6H 7H KH");
        final Hand hand2 = new Hand("4H 5C 6H 7H KH");

        Assert.assertEquals(hand2.lessThan(hand1), false);
        Assert.assertEquals(hand1.lessThan(hand2), false);
        Assert.assertEquals(hand1.compareTo(hand2), 0);
        Assert.assertEquals(hand1.equals(hand2), true);
        Assert.assertEquals(hand1.hashCode() == hand2.hashCode(), true);

    }

    @Test
    public void checkHandInequality() {
        final Hand hand1 = new Hand("4H 5C 6H 7H KH");
        final Hand hand2 = new Hand("4H 5C 6H 7H AH");

        Assert.assertEquals(hand2.lessThan(hand1), false);
        Assert.assertEquals(hand1.lessThan(hand2), true);
        Assert.assertEquals(hand1.compareTo(hand2), -1);
        Assert.assertEquals(hand1.equals(hand2), false);
        Assert.assertEquals(hand1.hashCode() == hand2.hashCode(), false);

    }

    @Test
    public void checkSameHand() {
        final Hand hand1 = new Hand("4H 5C 6H 7H 2H");
        final Hand hand2 = new Hand("4C 5H 6C 7C 2S");

        Assert.assertEquals(hand1.biggerThan(hand2), false);
        Assert.assertEquals(hand1.lessThan(hand2), false);
        Assert.assertEquals(hand1.same(hand2), true);

    }

    @Test
    public void checkBetterHand() {
        final Hand hand1 = new Hand("4H 4C 6H 7H 2H");
        final Hand hand2 = new Hand("4H 5C 6H 7H AH");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkStraightFlushBetterThanPoker() {
        final Hand hand1 = new Hand("4H 4C 4S 4D 2H");
        final Hand hand2 = new Hand("4H 5H 6H 7H 8H");

        Assert.assertEquals(hand1.lessThan(hand2), true);

    }

    @Test
    public void checkTwoPairs() {
        final Hand hand1 = new Hand("4H 4C 3S 3D 2H");
        final Hand hand2 = new Hand("AD AH KH KD QH");

        Assert.assertEquals(hand1.lessThan(hand2), true);
    }

    @Test
    public void checkDrillThanTwoPair() {
        final Hand hand1 = new Hand("4H 4C 4S 3D 2H");
        final Hand hand2 = new Hand("AD AH KH KD QH");

        Assert.assertEquals(hand1.biggerThan(hand2), true);
    }

    @Test
    public void checkStraightFlushBetterThanFullHouse() {
        final Hand hand1 = new Hand("KH KC KS AD AH");
        final Hand hand2 = new Hand("4H 5H 6H 7H 8H");

        Assert.assertEquals(hand1.lessThan(hand2), true);
    }

    @Test
    public void checkRoyalFlushBetterThanStraightFlush() {
        final Hand hand1 = new Hand("TC JC QC KC AC");
        final Hand hand2 = new Hand("4H 5H 6H 7H 8H");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkHighCards() {
        final Hand hand1 = new Hand("AC TC 8H 9C 2S");
        final Hand hand2 = new Hand("4H 5H 9C TC QD");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkStraights() {
        final Hand hand1 = new Hand("5H 6C 7S 8D 9H");
        final Hand hand2 = new Hand("6C 7H 8C 9C TD");

        Assert.assertEquals(hand1.lessThan(hand2), true);

    }

    @Test
    public void checkStraightFlushes() {
        final Hand hand1 = new Hand("5H 6H 7H 8H 9H");
        final Hand hand2 = new Hand("4C 5C 6C 7C 8C");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkStraightFlushesWithHighCard() {
        final Hand hand1 = new Hand("5H 6H 7H 8H 9C");
        final Hand hand2 = new Hand("4C 5C 6C 7C 8C");

        Assert.assertEquals(hand1.lessThan(hand2), true);

    }

    @Test
    public void checkExample1() {
        final Hand hand1 = new Hand("5H 5C 6S 7S KD");
        final Hand hand2 = new Hand("2C 3S 8S 8D TD");

        Assert.assertEquals(hand1.lessThan(hand2), true);

    }

    @Test
    public void checkExample2() {
        final Hand hand1 = new Hand("5D 8C 9S JS AC");
        final Hand hand2 = new Hand("2C 5C 7D 8S QH");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkExample3() {
        final Hand hand1 = new Hand("2D 9C AS AH AC");
        final Hand hand2 = new Hand("3D 6D 7D TD QD");

        Assert.assertEquals(hand1.lessThan(hand2), true);

    }

    @Test
    public void checkExample4() {
        final Hand hand1 = new Hand("4D 6S 9H QH QC");
        final Hand hand2 = new Hand("3D 6D 7H QD QS");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

    @Test
    public void checkExample5() {
        final Hand hand1 = new Hand("2H 2D 4C 4D 4S");
        final Hand hand2 = new Hand("3C 3D 3S 9S 9D");

        Assert.assertEquals(hand1.biggerThan(hand2), true);

    }

}
