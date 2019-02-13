package com.voodoo98.eulerproject.solutions;

import java.util.HashSet;
import java.util.Set;

import com.voodoo98.eulerproject.prime.PrimeFactor;
import com.voodoo98.eulerproject.prime.PrimeFactorDecomposition;

public class solution005 {

    public static void main(final String[] args) {
        final Set<PrimeFactor> primeFactors = new HashSet<>();
        final PrimeFactorDecomposition primeFactorDecomposition = new PrimeFactorDecomposition();
        for (int i = 2; i <= 20; i++) {
            primeFactors.addAll(primeFactorDecomposition.count(i));
        }
        int multiply = 1;
        for (final PrimeFactor primeFactor : primeFactors) {
            multiply *= primeFactor.getPrime();
        }
        System.err.println(multiply);
    }
}
