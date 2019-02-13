package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.voodoo98.eulerproject.poker.Hand;

public class solution054 {

	private static final String SEPARATOR = " ";

	public static void main(final String[] args) throws IOException {
		final long time = System.currentTimeMillis();

		int counter = 0;
		for (final String string : Files.readAllLines(Paths.get("resources/p054_poker.txt"))) {
			final String[] split = string.split(SEPARATOR);
			final String[] firstPlayerCards = new String[5];
			final String[] secondPlayerCards = new String[5];
			System.arraycopy(split, 0, firstPlayerCards, 0, 5);
			System.arraycopy(split, 5, secondPlayerCards, 0, 5);
			final Hand hand1 = new Hand(firstPlayerCards);
			final Hand hand2 = new Hand(secondPlayerCards);
			if (hand1.biggerThan(hand2)) {
				counter++;
			}
		}
		System.err.println("Result: " + counter);
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

}
