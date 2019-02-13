package com.voodoo98.eulerproject.solutions;

public class solution039 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static int count() {
        final int[] array = new int[1001];
        final int limit = (int) Math.sqrt(100000000);
        for (int a = 1; a < limit; a++) {
            for (int b = 1; b < limit; b++) {
                final int diagonalInt = countDiagonal(a, b);
                if (0 < diagonalInt) {
                    final int p = a + b + diagonalInt;
                    if (p <= 1000) {
                        array[p]++;
                    }
                }
            }
        }
        return indexOfLargest(array);
    }

    private static int countDiagonal(final int a, final int b) {
        final double sqrt = Math.sqrt(a * a + b * b);
        return sqrt == (int) sqrt ? (int) sqrt : -1;
    }

    public static int indexOfLargest(final int[] array) {
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}
