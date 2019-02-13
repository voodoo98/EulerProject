package com.voodoo98.eulerproject.fibonacci;

public class Fibonacci {

	private long first;
	private long second;

	public Fibonacci(final long startFirst, final long startSecond) {
		this.first = startFirst;
		this.second = startSecond;
	}

	public long count() {
		final long result = this.first + this.second;
		this.first = this.second;
		this.second = result;
		return result;
	}

	public long getFirst() {
		return this.first;
	}

	public long getSecond() {
		return this.second;
	}

	@Override
	public String toString() {
		return "Fibonacci [first=" + this.first + ", second=" + this.second + "]";
	}

}
