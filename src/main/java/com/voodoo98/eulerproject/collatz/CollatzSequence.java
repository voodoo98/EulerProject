package com.voodoo98.eulerproject.collatz;

public class CollatzSequence {

    private final long startNumber;
    private long n;

    public CollatzSequence(final long startNumber) {
        this.startNumber = startNumber;
        this.n = startNumber;
    }

    public long countNext() {
        this.n = (this.n % 2 == 0) ? this.n / 2 : 3 * this.n + 1;
        return this.n;
    }

    public int countChainCount() {
        int counter = 1;
        while (1 < this.getActualNumber()) {
            this.countNext();
            counter++;
        }
        return counter;

    }

    public long getStartNumber() {
        return this.startNumber;
    }

    public long getActualNumber() {
        return this.n;
    }

}
