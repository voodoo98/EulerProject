package com.voodoo98.eulerproject.solutions;

import java.text.ParseException;

public class solution019 {

    private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(final String[] args) throws ParseException {

        int sundayCounter = 0;
        int counter = 2; // 1901.01.01 = Tuesday
        for (int year = 1901; year <= 2000; year++) {
            for (int m = 0; m < 12; m++) {
                for (int j = 1; j <= DAYS[m] + addLeapYear(year, m); j++) {
                    if (j == 1 && counter % 7 == 0) {
                        final String date = year + "-" + (m + 1) + "-" + j;
                        System.err.println(date);
                        sundayCounter++;
                    }
                    counter++;
                }
            }
        }

        System.err.println("Result: " + sundayCounter);

    }

    private static int addLeapYear(final int year, final int month) {
        return month == 1 && isLeapYear(year) ? 1 : 0;
    }

    private static boolean isLeapYear(final int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

}
