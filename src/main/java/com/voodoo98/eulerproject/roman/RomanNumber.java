package com.voodoo98.eulerproject.roman;

public enum RomanNumber {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int digit;

    private RomanNumber(final int digit) {
        this.digit = digit;
    }

    public int getValue() {
        return this.digit;
    }

    private static RomanNumber getDigit(final String romanNumber, final int index) {
        RomanNumber result = null;
        try {
            result = valueOf(String.valueOf(romanNumber.charAt(index)));
        } catch (final Exception ex) {
        }
        return result;
    }

    public static int convertToArabic(final String romanString) {
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < romanString.length(); i++) {
            final RomanNumber r = getDigit(romanString, i);
            if (r != null) {
                sum += r.getValue();
                if (prev < r.getValue()) {
                    sum -= 2 * prev;
                }
                prev = r.getValue();
            } else {
                return -1;
            }
        }
        return sum;
    }

    public static String convertToRoman(int mInt) {
        final String[] rnChars = { "M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I" };
        final int[] rnVals = { 1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < rnVals.length; i++) {
            final int numberInPlace = mInt / rnVals[i];
            if (0 < numberInPlace) {
                result.append(numberInPlace == 4 && i > 0 ? rnChars[i] + rnChars[i - 1] : new String(new char[numberInPlace]).replace("\0", rnChars[i]));
                mInt = mInt % rnVals[i];
            }
        }
        return result.toString();
    }

    public static boolean isMinimalForm(final String romanString) {
        return convertToRoman(convertToArabic(romanString)).equals(romanString);
    }

}
