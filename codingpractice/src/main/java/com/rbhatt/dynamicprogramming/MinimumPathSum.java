package com.rbhatt.dynamicprogramming;

//Array
//Dynamic Programming

//Leetcode question # 64
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        if ( grid == null || grid.length < 1) {
            return 0;
        }

        //Keeping another 2D array to store minimum path from (0,0)
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        //finding path sum from (0,0) for first row.
        for(int j=1; j < dp[0].length; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        //finding path sum from (0,0) for first column.
        for(int i=1; i < dp.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //calculate sum along the path
        for(int i = 1; i < dp.length; i++){

            for(int j = 1; j<dp[0].length; j++){

                //finding min path using Math.min(top, left).
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {

        MinimumPathSum ob = new MinimumPathSum();

        int[][] a = new int[3][3];

        a[0][0] = 1; a[0][1] = 3; a[0][2] = 1;
        a[1][0] = 1; a[1][1] = 5; a[1][2] = 1;
        a[2][0] = 4; a[2][1] = 2; a[2][2] = 1;

        System.out.println(ob.minPathSum(a));

        int[][] b = new int[3][3];

        b[0][0] = 0; b[0][1] = 0; b[0][2] = 0;
        b[1][0] = 1; b[1][1] = 1; b[1][2] = 0;
        b[2][0] = 1; b[2][1] = 1; b[2][2] = 0;

        System.out.println(ob.minPathSum(b));

        int[][] c = new int[1][1];

        c[0][0] = 5;

        System.out.println(ob.minPathSum(c));

    }

}
