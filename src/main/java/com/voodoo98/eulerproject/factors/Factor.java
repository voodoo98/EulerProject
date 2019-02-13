package com.voodoo98.eulerproject.factors;

public class Factor {

    private final long number;

    public Factor(final long number) {
        this.number = number;
    }

    public int count() {
        int counter = 1;
        for (int i = 1; i <= this.number / 2; i++) {
            if (this.number % i == 0) {
                counter++;
            }
        }

        return counter;
    }

}
