package com.voodoo98.eulerproject.divisors;

public class Divisor extends ProperDivisor {

    public Divisor(final long number) {
        super(number);
    }

    @Override
    public ProperDivisorList getDivisorList() {
        final ProperDivisorList divisorList = super.getDivisorList();
        divisorList.add(this.getNumber());
        return divisorList;

    }

}
