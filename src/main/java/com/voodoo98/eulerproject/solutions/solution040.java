package com.voodoo98.eulerproject.solutions;

public class solution040 {

    private static final int LIMIT = 1000000;
    private static final int COUNT_LIMIT = LIMIT / 10;

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        final StringBuilder generateString = generateString();
        long sum = 1;
        for (int i = 1; i <= COUNT_LIMIT; i *= 10) {
            sum *= d(generateString, i);
        }
        return sum;
    }

    private static StringBuilder generateString() {
        final StringBuilder sb = new StringBuilder(COUNT_LIMIT);
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            sb.append(i);
        }
        return sb;

    }

    private static long d(final StringBuilder sb, final int n) {
        return Character.getNumericValue(sb.charAt(n - 1));
    }

}
