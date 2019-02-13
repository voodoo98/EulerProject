package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution049 {

    private static final int FIRST_ELEMENT_3_TERM = 1488;

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static String count() {

        final PrimeSieve primeSieve = new PrimeSieve();
        primeSieve.count();

        for (int a = FIRST_ELEMENT_3_TERM + 1; a < 10000; a++) {
            for (int j = FIRST_ELEMENT_3_TERM + 1; a + 2 * j < 10000; j++) {
                final int b = a + j;
                final int c = b + j;
                if (primeSieve.isPrime(a) && primeSieve.isPrime(b) && primeSieve.isPrime(c)) {
                    if (Permute.arePermutatedPairs(a, b) && Permute.arePermutatedPairs(a, c)) {
                        return String.format("%s%s%s", a, b, c);
                    }
                }
            }
        }

        return null;
    }

}
