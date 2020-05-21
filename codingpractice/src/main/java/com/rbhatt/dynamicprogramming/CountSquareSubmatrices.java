package com.rbhatt.dynamicprogramming;

//Array
//dynamic programming
//Leetcode question # 1277
public class CountSquareSubmatrices {

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    continue;
                }

                if (i > 0 && j > 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j]), matrix[i-1][j-1]) + 1;
                }

                result += matrix[i][j];

            }
        }

        return result;
    }

    public static void main(String[] args) {

        CountSquareSubmatrices ob = new CountSquareSubmatrices();

        int[][] matrix = new int[3][4];

        matrix[0][0] = 0; matrix[0][1] = 1; matrix[0][2] = 1; matrix[0][3] = 1;
        matrix[1][0] = 1; matrix[1][1] = 1; matrix[1][2] = 1; matrix[1][3] = 1;
        matrix[2][0] = 0; matrix[2][1] = 1; matrix[2][2] = 1; matrix[2][3] = 1;

        System.out.println(ob.countSquares(matrix));
    }

}
