package com.voodoo98.eulerproject.adjacents;

public class AdjacentNumber {

    private final String stringNumber;
    private final int digitLength;

    public AdjacentNumber(final String stringNumber, final int digitLength) {
	this.stringNumber = stringNumber;
	this.digitLength = digitLength;
    }

    public long count() {
	long max = 0;
	for (int i = 0; i < this.stringNumber.length() - this.digitLength; i++) {
	    long result = 1;
	    for (int j = 0; j < this.digitLength; j++) {
		final Character ch = this.stringNumber.charAt(i + j);
		result *= Character.getNumericValue(ch);
	    }
	    if (max < result) {
		max = result;
	    }
	}
	return max;
    }

    public String getStringNumber() {
	return this.stringNumber;
    }

    public int getDigits() {
	return this.digitLength;
    }

}
