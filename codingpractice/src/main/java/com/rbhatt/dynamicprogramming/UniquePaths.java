package com.rbhatt.dynamicprogramming;

//Array
//Dynamic Programming
//Leetcode question # 62
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];

        //n - row
        //m - column
        //fill up the last row
        for (int i = 0; i < m; i++) {
            dp[n-1][i] = 1;
        }

        //fill up the last column
        for (int i = 0; i < n; i++) {
            dp[i][m-1] = 1;
        }

        //fill up rest of the array
        //number of possible unique path for array[i][j] = array[i+1][j] + array[i][j+1]
        for (int j = m-2; j >= 0; j--) {
            for (int i = n-2; i >= 0; i--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        UniquePaths ob = new UniquePaths();

        System.out.println(ob.uniquePaths(7,3));

        System.out.println(ob.uniquePaths(3,2));

        System.out.println(ob.uniquePaths(2,2));

    }

}
