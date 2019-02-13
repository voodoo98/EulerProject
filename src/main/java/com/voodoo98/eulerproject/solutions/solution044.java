package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.polygonalnumber.PentagonalNumber;

public class solution044 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        final PentagonalNumber pentagonalSieve = new PentagonalNumber(3000);
        pentagonalSieve.count();

        long min = Long.MAX_VALUE;
        final long[] array = pentagonalSieve.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                final long d = array[j] - array[i];
                if (PentagonalNumber.isPentagonal(array[i] + array[j]) && PentagonalNumber.isPentagonal(d)) {
                    if (d < min) {
                        min = d;
                    }
                }
            }

        }
        return min;
    }
}
