package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.polygonalnumber.SquareNumber;

public class solution064 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
    private static long count() {
        int sum = 0;
        for (int n = 2; n < 10000; n++) {
            if (!SquareNumber.isSquare(n)) {
                final int sqrt = (int) Math.sqrt(n);
                int period = 0;
                int m = 0;
                int d = 1;
                int a = sqrt;
                do {
                    m = d * a - m;
                    d = (n - m * m) / d;
                    a = (sqrt + m) / d;
                    period++;
                } while (a != 2 * sqrt);
                if (period % 2 == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
