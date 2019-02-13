package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class solution082 {

    public static long main2(final String[] args) {
        System.out.println("Hello");
        return 10l;
    }

    public static void main(final String[] args) throws IOException, InterruptedException {
        final long time = System.currentTimeMillis();

        System.err.println("Result: " + count());
        System.err.println("Time: " + (System.currentTimeMillis() - time));
    }

    public static long count() throws IOException, InterruptedException {
        final int[][] grid = loadRawMatrixFromFile();
        final int size = grid.length;

        return size;
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

}
