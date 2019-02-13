package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class solution081 {

    private static final int DEFAULT_VALUE = 100_000;

    public static void main(final String[] args) throws IOException {
	final long time = System.currentTimeMillis();

	System.err.println("My solution: " + count());
	System.err.println("Dynamic programming solution: " + dynamcicProgramming());
	System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    // Idea from this solution:
    // https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p081.java
    public static long dynamcicProgramming() throws IOException {
	final int[][] grid = loadRawMatrixFromFile();
	final int size = grid.length;

	for (int i = size - 2; i >= 0; i--) {
	    grid[size - 1][i] += grid[size - 1][i + 1];
	    grid[i][size - 1] += grid[i + 1][size - 1];
	}

	for (int i = size - 2; i >= 0; i--) {
	    for (int j = size - 2; j >= 0; j--) {
		grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
	    }
	}

	return grid[0][0];
    }

    public static long count() throws IOException {
	final int[][] array = loadRawMatrixFromFile();
	final int[][] matrix = convertLowerTriangularMatrix(array);

	return countMin(matrix);
    }

    private static int countMin(final int[][] matrix) {
	for (int i = matrix.length - 1; 0 < i; i--) {
	    final int[] row = matrix[i];
	    for (int j = 0; j < row.length; j++) {
		final int left = row[j];
		final int right = j < row.length - 1 ? row[j + 1] : 0;
		final int min = Math.min(left, right);
		if (0 < i) {
		    matrix[i - 1][j] += min;
		}
	    }
	}
	return matrix[0][0] - DEFAULT_VALUE;
    }

    private static int[][] loadRawMatrixFromFile() throws IOException {
	final List<String> readAllLines = Files.readAllLines(Paths.get("resources/p08x_matrix_sample2.txt"));
	final int DIM = readAllLines.get(0).split(",").length;
	final int[][] matrix = new int[DIM][DIM];

	for (int i = 0; i < DIM; i++) {
	    final String split[] = readAllLines.get(i).split(",");
	    for (int j = 0; j < split.length; j++) {
		matrix[i][j] = Integer.parseInt(split[j]);
	    }
	}
	return matrix;
    }

    private static int[][] convertLowerTriangularMatrix(final int[][] matrix) {
	final int length = matrix.length;
	final int treeLength = 2 * length;
	final int[][] result = new int[treeLength][treeLength];
	for (final int[] row : result) {
	    Arrays.fill(row, DEFAULT_VALUE);
	}
	for (int n = 0; n < treeLength; n++) {
	    int k = 0;
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
		    if (i + j == n - 1) {
			result[n][k++] = 0 <= i && i < length && 0 <= j && j < length ? matrix[j][i] : DEFAULT_VALUE;
		    }
		}
	    }
	}
	return result;
    }

}
