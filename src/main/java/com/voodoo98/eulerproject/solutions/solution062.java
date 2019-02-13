package com.voodoo98.eulerproject.solutions;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.voodoo98.eulerproject.biginteger.BigInteger;
import com.voodoo98.eulerproject.utils.StringUtils;

public class solution062 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    private static String count() {
        final Multiset<String> bag = HashMultiset.create();
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (i % 10 != 0) {
                list.add(cube(i).toString());
            }
        }
        String result = null;
        for (final String cube : list) {
            bag.add(cube);
            for (final String cubePerm : list) {
                if (!cube.equals(cubePerm) && cube.length() == cubePerm.length() && StringUtils.arePermutatedStrings(cube, cubePerm)) {
                    bag.add(cube);
                }
            }
            if (bag.count(cube) == 5) {
                result = cube;
                break;
            }
        }
        return result;

    }

    private static BigInteger cube(final int i) {
        return new BigInteger(i).multiply(i).multiply(i);
    }

}
