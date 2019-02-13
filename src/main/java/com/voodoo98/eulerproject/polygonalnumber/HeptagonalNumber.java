package com.voodoo98.eulerproject.polygonalnumber;

public class HeptagonalNumber extends PolygonalNumber {

    public static boolean isHeptagonal(final long n) {
        final double p = (Math.sqrt(40 * n + 9) + 3) / 10;
        return p == (long) p;
    }

    public static long getHeptagonal(final long n) {
        return n * (5 * n - 3) / 2;
    }

    @Override
    protected long formula(final long n) {
        return getHeptagonal(n);
    }

}
