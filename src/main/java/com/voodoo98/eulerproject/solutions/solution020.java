package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class solution020 {

    public static void main(final String[] args) {

        final BigInteger bigInteger = new BigInteger(1);
        bigInteger.factorial(100);
        System.err.println(bigInteger.sumDigits());
    }
}
