package com.voodoo98.eulerproject.polygonalnumber;

import java.util.Arrays;

public abstract class PolygonalNumber {

    protected final long[] array;
    protected final long limit;
    protected PolygonalType type;

    public PolygonalNumber() {
        this(1_000_000);
    }

    protected abstract long formula(long n);

    public static boolean isPolygonalNumber(final long n) {
        return TriangleNumber.isTriangle(n) || SquareNumber.isSquare(n) || PentagonalNumber.isPentagonal(n) || HexagonalNumber.isHexagonal(n)
                || HeptagonalNumber.isHeptagonal(n) || OctagonalNumber.isOctagonal(n);
    }

    public PolygonalNumber(final int limit) {
        this.limit = limit;
        this.array = new long[limit];
    }

    public void count() {
        for (int i = 1; i < this.limit + 1; i++) {
            this.array[i - 1] = this.formula(i);
        }
    }

    public long[] getSubArray(final int from, final int to) {
        return Arrays.stream(this.array).filter(element -> from <= element && element < to).toArray();
    }

    public long[] getArray() {
        return this.array;
    }

    public PolygonalType getType() {
        return this.type;
    }

    public void setType(final PolygonalType polygonalType) {
        this.type = polygonalType;
    }

}
