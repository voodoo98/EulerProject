package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution037 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() {
        final PrimeSieve primeSieve = new PrimeSieve();
        primeSieve.count();
        long sum = 0;
        for (int i = 10; i < 1_000_000; i++) {
            if (primeSieve.isPrime(i)) {
                if (checkWay(primeSieve, truncateNumberRightToLeft(i)) && checkWay(primeSieve, truncateNumberLeftToRight(i))) {
                    sum += i;
                }
            }

        }
        return sum;

    }

    private static boolean checkWay(final PrimeSieve primeSieve, final int[] truncateWay) {
        boolean isAllPrime = true;
        for (final int element : truncateWay) {
            if (!primeSieve.isPrime(element)) {
                isAllPrime = false;
                break;
            }
        }
        return isAllPrime;
    }

    private static int[] truncateNumberLeftToRight(final int number) {
        final int length = NumberUtils.lengthOfNumber(number);
        final int[] result = new int[length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (number % Math.pow(10, length - 1 - i));
        }
        return result;
    }

    private static int[] truncateNumberRightToLeft(final int number) {
        final int length = NumberUtils.lengthOfNumber(number);
        final int[] result = new int[length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (number / Math.pow(10, length - 1 - i));
        }
        return result;
    }
}
