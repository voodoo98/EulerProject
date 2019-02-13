package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.voodoo98.eulerproject.roman.RomanNumber;

public class solution089 {

    public static void main(final String[] args) throws IOException {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count() throws IOException {
        final List<String> numbers = Files.readAllLines(Paths.get("resources/p089_roman.txt"));

        int sum = 0;
        for (final String number : numbers) {
            final int arabic = RomanNumber.convertToArabic(number);
            final String minimalForm = RomanNumber.convertToRoman(arabic);
            sum += (number.length() - minimalForm.length());
        }
        return sum;
    }

}
