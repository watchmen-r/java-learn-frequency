package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q008 {
    public int[][] searchZero() {
        int[][] matrix = { { 87, 0, 67 }, { 76, 92, 48 }, { 6, 9, 8 } };
        boolean[] rowCheck = new boolean[matrix.length];
        boolean[] columnCheck = new boolean[matrix[0].length];

        IntStream.range(0, matrix.length).forEach(row -> {
            IntStream.range(0, matrix[row].length).forEach(column -> {
                if (matrix[row][column] == 0) {
                    rowCheck[row] = true;
                    columnCheck[column] = true;
                }
            });
        });

        IntStream.range(0, rowCheck.length).forEach(row -> {
            if (rowCheck[row]) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[row][i] = 0;
                }
            }
        });

        IntStream.range(0, columnCheck.length).forEach(column -> {
            if (columnCheck[column]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][column] = 0;
                }
            }
        });
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

}
