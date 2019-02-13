package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.prime.PrimeSieve;

public class solution007 {

    public static void main(final String[] args) {

        final PrimeSieve primeSieve = new PrimeSieve();
        primeSieve.count();

        int counter = 1;
        int number = 1;
        while (counter < 10001) {
            number += 2;
            if (primeSieve.isPrime(number)) {
                counter++;
            }
        }
        System.err.println("Result:" + number);
    }
}
