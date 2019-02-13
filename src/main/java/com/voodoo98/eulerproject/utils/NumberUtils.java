package com.voodoo98.eulerproject.utils;

import java.util.Arrays;

public class NumberUtils {

    private static final long[] TEN_POWS = new long[19];

    static {
        TEN_POWS[0] = 1;
        for (int i = 1; i < TEN_POWS.length; i++) {
            TEN_POWS[i] = TEN_POWS[i - 1] * 10;
        }
    }

    private NumberUtils() {
    }

    public static String paddingNotNullNumberWith0(final int number, final int count) {
        final StringBuilder result = new StringBuilder(number + "");
        if (number != 0) {
            for (int i = 0; i < count; i++) {
                result.append("0");
            }
        }
        return result.toString();
    }

    public static int lengthOfNumber(final long n) {
        return (int) (Math.log10(n) + 1);
    }

    public static int[] longConvertToArray(final long number) {
        final int[] result;
        if (0 < number) {
            final int length = lengthOfNumber(number);
            result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = getDigit(number, length, i);
            }
        } else {
            result = new int[] {};
        }
        return result;

    }

    public static int[] longConvertToArray(final long n, final int length) {
        final String number = String.format("%" + length + "d", n);
        final int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = Character.getNumericValue(number.charAt(i));
        }
        return result;
    }

    public static int arrayConvertInt(final int[] array) {
        final int length = array.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(10, length - i - 1) * array[i];
        }
        return sum;
    }

    public static long arrayConvertLong(final int[] array) {
        final int length = array.length;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(10, length - i - 1) * array[i];
        }
        return sum;
    }

    public static String intArrayToString(final int[] array) {
        final StringBuilder strRet = new StringBuilder();
        for (final int i : array) {
            strRet.append(Integer.toString(i));
        }
        return strRet.toString();
    }

    public static int[] countCircularNumbers(final int n) {
        final int length = lengthOfNumber(n);
        if (0 < length) {
            final int[] result = new int[length];
            final int[] array = longConvertToArray(n);
            result[0] = arrayConvertInt(array);
            for (int j = 1; j < result.length; j++) {
                final int first = array[0];
                for (int i = 1; i < length; i++) {
                    array[i - 1] = array[i];
                }
                array[length - 1] = first;
                result[j] = arrayConvertInt(array);
            }
            return result;
        } else {
            return new int[] {};
        }

    }

    public static boolean isPalindrome(final String number) {
        final String reverse = new StringBuilder(number).reverse().toString();
        return number.equals(reverse);
    }

    public static boolean isPalindrome(final long number) {
        long palindrome = number;
        long reverse = 0;

        while (palindrome != 0) {
            final long remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
    }

    public static boolean isRightAngleTriangle(final int a, final int b, final int c) {
        if (c < b || c < a || a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("Must have: a < c && b < c && 0 < a && 0 < b");
        }
        return a * a + b * b == c * c;
    }

    public static long reverse(final long number) {
        long resultNumber = 0;
        for (long i = number; i != 0; i /= 10) {
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;
    }

    public static int maxInArray(final int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    public static int sumArray(final int[] array) {
        return Arrays.stream(array).sum();
    }

    public static long sumArray(final long[] array) {
        return Arrays.stream(array).sum();
    }

    public static int sumArray(final int[] array, final int from, final int to) {
        return sumArray(Arrays.copyOfRange(array, from, to + 1));
    }

    private static int getDigit(final long number, final int length, final int digit) {
        return Math.round(number / TEN_POWS[length - digit - 1] % 10);
    }

    private static int getDigit(final long number, final int digit) {
        final int length = lengthOfNumber(number);
        return getDigit(number, length, digit);
    }

    public static int sumDigits(final byte[] array) {
        int sum = 0;
        for (final byte element : array) {
            sum += element;
        }
        return sum;
    }

    public static int maxCountOfRecurringCycles(final String num) {
        return getRecurringCycles(num).length();
    }

    public static String getRecurringCycles(final String num) {
        String result = "";
        final int startIndex = num.indexOf(".") + 1;
        final String number = num.substring(startIndex);
        final int length = number.length();
        int max = 0;
        OUTER: for (int i = 0; i < length - max; i++) {
            for (int l = max; i + l < length - max; l++) {
                final String number1 = new StringBuilder(number).substring(i, i + l);
                if (i + 2 * l < length && max < i + 2 * l) {
                    final String number2 = new StringBuilder(number).substring(i + l, i + 2 * l);
                    if (number1.length() == number2.length() && number1.equals(number2)) {
                        if (max < number1.length()) {
                            max = number1.length();
                            result = number1;
                        }
                        continue OUTER;
                    }
                }
            }
        }
        return result;
    }

    public static int[] concatArrays(final int[]... arrays) {
        int length = 0;
        for (final int[] array : arrays) {
            length += array.length;
        }
        final int[] result = new int[length];
        int pos = 0;
        for (final int[] array : arrays) {
            for (final int element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }

    public static int[] concatArraysAsDigits(final int[]... arrays) {
        int length = 0;
        for (final int[] array : arrays) {
            length += array.length;
        }
        final int[] result = new int[length];
        int pos = 0;
        for (final int[] array : arrays) {
            for (final int element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }

    public static int getFirst2Digit(final int number) {
        final int length = lengthOfNumber(number);
        return getFirst2Digit(number, length - 1);
    }

    public static int getFirst2Digit(final int number, final int length) {
        return number / (int) Math.pow(10, length);
    }

    public static int getLast2Digit(final int number) {
        return number % 10;
    }
}
