package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.util.Arrays;

import com.voodoo98.eulerproject.polygonalnumber.TriangleNumber;
import com.voodoo98.eulerproject.utils.StringUtils;

public class solution042 {

    public static void main(final String[] args) throws IOException {
        final long time = System.currentTimeMillis();
        final String[] words = StringUtils.parseWordsFromResource("p042_words.txt");

        System.err.println("Result: " + count(words));
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static long count(final String[] words) {
        return Arrays.stream(words).filter(word -> TriangleNumber.isTriangle(TriangleNumber.sumWordToNumber(word))).count();
    }

}
