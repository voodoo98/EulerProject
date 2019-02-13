package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.divisors.ProperDivisorCache;

public class solution021 {

    public static void main(final String[] args) {

        final ProperDivisorCache cache = new ProperDivisorCache();
        for (int i = 0; i < 10000; i++) {
            cache.getSumOfDivisors(i);
        }

        long sum = 0;
        for (int i = 0; i < 10000; i++) {
            final long sumOfDivisors = cache.getSumOfDivisors(i);
            if (sumOfDivisors < 10000 && i != sumOfDivisors && i == cache.getSumOfDivisors(sumOfDivisors)) {
                sum += i;
            }
        }
        System.err.println("Result: " + sum);
    }
}
