package com.voodoo98.eulerproject.polygonalnumber;

public class OctagonalNumber extends PolygonalNumber {

    public static boolean isOctagonal(final long n) {
        final double p = (Math.sqrt(12 * n + 4) + 2) / 6;
        return p == (long) p;
    }

    public static long getOctagonal(final long n) {
        return n * (3 * n - 2);
    }

    @Override
    public long formula(final long n) {
        return OctagonalNumber.getOctagonal(n);
    }

}
