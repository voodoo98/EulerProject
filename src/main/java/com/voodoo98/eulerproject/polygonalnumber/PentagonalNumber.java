package com.voodoo98.eulerproject.polygonalnumber;

public class PentagonalNumber extends PolygonalNumber {

    public PentagonalNumber() {
        super();
    }

    public PentagonalNumber(final int limit) {
        super(limit);
    }

    public static boolean isPentagonal(final long n) {
        final double p = (Math.sqrt(1 + 24 * n) + 1) / 6;
        return p == (long) p;
    }

    public static long getPentagonal(final long n) {
        return n * (3 * n - 1) / 2;
    }

    @Override
    public long formula(final long n) {
        return getPentagonal(n);
    }

}
