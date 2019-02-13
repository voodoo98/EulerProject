package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.collatz.CollatzSequence;

public class solution014 {

    public static void main(final String[] args) {

        int max = 0;
        int result = 0;
        for (int i = 2; i <= 1_000_000; i++) {
            final CollatzSequence collatzSequence = new CollatzSequence(i);

            final int countChainCount = collatzSequence.countChainCount();
            if (max < countChainCount) {
                max = countChainCount;
                result = i;
            }
        }
        System.err.println("Result: " + result);

    }
}
