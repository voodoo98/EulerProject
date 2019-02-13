package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution046 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        final PrimeSieve primeSieve = new PrimeSieve();
        primeSieve.count();
        OUTER: for (int odd = 9; odd < 10000; odd += 2) {
            if (!primeSieve.isPrime(odd)) {
                for (int p = 2; p < odd; p++) {
                    if (primeSieve.isPrime(p)) {
                        int h = 1;
                        while (p + 2 * h * h <= odd) {
                            if (condition(odd, p, h++)) {
                                continue OUTER;
                            }
                        }
                    }
                }
                return odd;
            }
        }
        return -1;
    }

    private static boolean condition(final long odd, final long p, final int h) {
        return odd == p + 2 * h * h;
    }

}
