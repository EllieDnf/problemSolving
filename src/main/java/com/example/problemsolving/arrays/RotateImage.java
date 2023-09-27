package com.example.problemsolving.arrays;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
        System.out.println(Arrays.toString(a[0]));
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[j][i];
                matrix[i][j] = matrix[len - j - 1][i];

            }
        }
    }
}
