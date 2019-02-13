package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution065 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    // https://en.wikipedia.org/wiki/Continued_fraction#Infinite_continued_fractions
    private static long count() {
        final int startIndex = 4;
        final BigInteger a = new BigInteger(0);
        BigInteger h1 = new BigInteger(11);
        BigInteger h2 = new BigInteger(8);
        BigInteger h = null;
        long kk = 4;
        for (int k = 0; k < 100 - startIndex; k++) {
            if (k % 3 == 1) {
                a.setNumber(kk);
                kk += 2;
            } else {
                a.setNumber(1);
            }
            h = new BigInteger(a).multiply(h1).add(h2);
            h2 = h1;
            h1 = h;
        }
        return h.sumDigits();
    }

}
