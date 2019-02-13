package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.divisors.ProperDivisor;
import com.voodoo98.eulerproject.polygonalnumber.TriangleNumber;
import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution012 {

    public static void main(final String[] args) {
        final long time = System.currentTimeMillis();

        final PrimeSieve primeSieve = new PrimeSieve();
        primeSieve.count();
        long i = 1;
        while (true) {
            final long number = TriangleNumber.getTriangle(i);
            if (500 < ProperDivisor.getNumberOfDivisors(number)) {
                System.err.println("Result: " + number);
                break;
            }
            i++;
        }
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

}
