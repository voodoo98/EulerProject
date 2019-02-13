package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution063 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        int sum = 0;
        final int limit = 25;
        for (int k = 1; k < limit; k++) {
            final BigInteger base = new BigInteger(k);
            for (int n = 1; n < limit; n++) {
                if (base.pow(n).length() == n) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
