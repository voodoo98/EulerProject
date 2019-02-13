package com.voodoo98.eulerproject.polygonalnumber;

public class HexagonalNumber extends PolygonalNumber {

    public static boolean isHexagonal(final long n) {
        final double p = (Math.sqrt(1 + 8 * n) + 1) / 4;
        return p == (long) p;
    }

    public static long getHexagonal(final long n) {
        return n * (2 * n - 1);
    }

    @Override
    protected long formula(final long n) {
        return getHexagonal(n);
    }

}
