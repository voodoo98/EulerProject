package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.pandigital.PandigitalNumber;

public class solution038 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static String count() {
        String max = "";
        for (int i = 1; i < 10000; i++) {
            final StringBuilder number = new StringBuilder();
            int n = 1;
            while (number.length() < 9) {
                number.append(i * n);
                n++;
            }
            String string = number.toString();
            if (max.compareTo(string) < 0 && PandigitalNumber.isPandigital(Long.parseLong(string))) {
                max = string;
            }
        }
        return max;
    }

}
