package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class solution067 {

    public static void main(final String[] args) throws IOException {
        final int[][] array = loadArrayFromFile();

        for (int i = array.length - 1; 0 < i; i--) {
            final int[] row = array[i];
            for (int j = 0; j < row.length; j++) {
                final int left = row[j];
                final int right = j < row.length - 1 ? row[j + 1] : 0;
                final int max = Math.max(left, right);
                if (0 < i) {
                    array[i - 1][j] += max;
                }
            }
        }
        System.err.println("Result:" + array[0][0]);
    }

    private static int[][] loadArrayFromFile() throws IOException {
        final List<String> readAllLines = Files.readAllLines(Paths.get("resources/p067_triangle.txt"));
        final int size = readAllLines.size();
        final int[][] array = new int[size][size];
        for (int k = 0; k < size; k++) {
            final String row = readAllLines.get(k);
            final String[] split = row.split(" ");
            for (int i = 0; i < split.length; i++) {
                final String element = split[i];
                array[k][i] = Integer.parseInt(element);
            }
        }
        return array;
    }

}
