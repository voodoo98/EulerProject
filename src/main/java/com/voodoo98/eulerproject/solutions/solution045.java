package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.polygonalnumber.HexagonalNumber;
import com.voodoo98.eulerproject.polygonalnumber.PentagonalNumber;

public class solution045 {

    private static final int LIMIT = 40755;

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        long j = 1;
        long t = 1;
        while (t < Long.MAX_VALUE) {
            if (PentagonalNumber.isPentagonal(t) && HexagonalNumber.isHexagonal(t)) {
                if (LIMIT < t) {
                    break;
                }
            }
            t += ++j;
        }
        return t;
    }
}
