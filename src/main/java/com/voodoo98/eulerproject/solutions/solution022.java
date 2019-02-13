package com.voodoo98.eulerproject.solutions;

import java.io.IOException;

import com.voodoo98.eulerproject.polygonalnumber.TriangleNumber;
import com.voodoo98.eulerproject.utils.StringUtils;

public class solution022 {

    public static void main(final String[] args) throws IOException {

        final String[] names = StringUtils.parseSortWordsFromResource("p022_names.txt");

        long mainSum = 0;
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final int sum = TriangleNumber.sumWordToNumber(name);
            mainSum += sum * (i + 1);
        }
        System.err.println(mainSum);
    }

}
