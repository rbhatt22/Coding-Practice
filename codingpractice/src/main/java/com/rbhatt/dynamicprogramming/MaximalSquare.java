package com.rbhatt.dynamicprogramming;

import java.util.*;

//Dynamic programming
//Leetcode question # 221
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int maxSquare = 0;
        int row = matrix.length;
        int column = row > 0? matrix[0].length : 0;

        //creating 2D array to store DP
        int[][] dp = new int[row+1][column+1];

        //set rest of the dp
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i-1][j-1] == '1') {
                    int temp = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    dp[i][j] = temp;
                    if (maxSquare < temp) {
                        maxSquare = temp;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }


        return maxSquare*maxSquare;
    }

    public static void main(String[] args) {

        MaximalSquare ob = new MaximalSquare();

        char[][] a = new char[4][5];

        a[0][0] = '1'; a[0][1] = '0'; a[0][2] = '1'; a[0][3] = '0'; a[0][4] = '0';
        a[1][0] = '1'; a[1][1] = '0'; a[1][2] = '1'; a[1][3] = '1'; a[1][4] = '1';
        a[2][0] = '1'; a[2][1] = '1'; a[2][2] = '1'; a[2][3] = '1'; a[2][4] = '1';
        a[3][0] = '1'; a[3][1] = '0'; a[3][2] = '0'; a[3][3] = '1'; a[3][4] = '0';
        System.out.println(ob.maximalSquare(a));

        char[][] b = new char[4][5];
        b[0][0] = '1'; b[0][1] = '1'; b[0][2] = '1'; b[0][3] = '0'; b[0][4] = '0';
        b[1][0] = '1'; b[1][1] = '1'; b[1][2] = '1'; b[1][3] = '0'; b[1][4] = '1';
        b[2][0] = '1'; b[2][1] = '1'; b[2][2] = '1'; b[2][3] = '0'; b[2][4] = '1';
        b[3][0] = '1'; b[3][1] = '0'; b[3][2] = '0'; b[3][3] = '1'; b[3][4] = '0';

        System.out.println(ob.maximalSquare(b));

        char[][] c = new char[1][1];
        c[0][0] = '1';

        System.out.println(ob.maximalSquare(c));

        System.out.println(ob.maximalSquare(new char[][] {}));

    }

}
