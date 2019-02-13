package com.voodoo98.eulerproject.factorial;

public class Factorial {

    public long getFactorial(final int n) {
        return (1 < n) ? this.getFactorial(n - 1) * n : 1;
    }
}
