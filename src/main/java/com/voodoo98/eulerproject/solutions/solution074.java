package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.utils.MathUtils;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution074 {

    private static final int LONGEST_NON_REPEATING_CHAIN = 60;
    private static int[] permArrays;

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {

        permArrays = new int[10];
        for (int i = 0; i < permArrays.length; i++) {
            permArrays[i] = (int) MathUtils.factorial(i);
        }
        int sum = 0;
        for (int i = 1; i < 1_000_000; i++) {
            sum += countFactorialChain(i) == LONGEST_NON_REPEATING_CHAIN ? 1 : 0;
        }
        return sum;
    }

    private static int countFactorialChain(final int i) {
        final List<Integer> visitedNodes = new ArrayList<>();
        int n = sumDigitFactorials(i);
        int counter = 1;
        while (!visitedNodes.contains(n) && counter < LONGEST_NON_REPEATING_CHAIN) {
            visitedNodes.add(n);
            n = sumDigitFactorials(n);
            counter++;
        }
        return counter;
    }

    private static int sumDigitFactorials(final int number) {
        final int[] digits = NumberUtils.longConvertToArray(number);
        int sum = 0;
        for (final int digit : digits) {
            sum += permArrays[digit];
        }
        return sum;

    }
}
