package com.voodoo98.eulerproject.matrix;

public class Matrix {

	private final String numbers;
	private final int dimension;

	public Matrix(final String numbers, final int dimension) {
		this.numbers = numbers;
		this.dimension = dimension;
	}

	public Matrix(final String numbers) {
		this(numbers, (int) Math.sqrt(numbers.split(" ").length));
	}

	public int[][] convert() {
		final int[][] result = new int[this.dimension][this.dimension];
		final String[] split = this.numbers.split(" ");
		if (split.length != this.dimension * this.dimension) {
			throw new IllegalArgumentException("Wrong input");
		} else {
			for (int i = 0; i < split.length; i++) {
				result[i / this.dimension][i % this.dimension] = Integer.parseInt(split[i]);
			}
		}
		return result;
	}

	public String getNumbers() {
		return this.numbers;
	}

	public int getDimension() {
		return this.dimension;
	}

	@Override
	public String toString() {
		return "Matrix [numbers=" + this.numbers + ", dimension=" + this.dimension + "]";
	}

}
