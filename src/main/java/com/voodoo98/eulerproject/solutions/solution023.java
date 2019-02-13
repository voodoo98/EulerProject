package com.voodoo98.eulerproject.solutions;

import java.util.List;

import com.voodoo98.eulerproject.perfectnumber.AmbudantSieve;

public class solution023 {

    private static final int MAX = 28123;

    public static void main(final String[] args) {

        final AmbudantSieve ambudantSieve = new AmbudantSieve(MAX);
        final List<Integer> count = ambudantSieve.count();
        System.err.println("Result:" + count.stream().mapToInt(Integer::intValue).sum());
    }
}
