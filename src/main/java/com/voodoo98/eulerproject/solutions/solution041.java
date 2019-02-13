package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.pandigital.PandigitalNumber;
import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution041 {

    private static final int LIMIT = 10_000_000;

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        final PrimeSieve primeSieve = new PrimeSieve(LIMIT);
        primeSieve.count();
        long max = 0;
        for (int i = 2; i < LIMIT; i++) {
            if (primeSieve.isPrime(i) && PandigitalNumber.isPandigital(i)) {
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }
}
