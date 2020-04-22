package com.rbhatt.binarysearch;

//Array
//Binary Search

//Leetcode 30 day challenge
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
public class LeftmostColumnwithAOne {

    public int leftMostColumnWithOne(int[][] binaryMatrix) {

        //List<Integer> dimensions = binaryMatrix.dimensions();
        int row = binaryMatrix.length;
        int column = binaryMatrix[0].length;
        int result = Integer.MAX_VALUE;

        for (int i = row - 1; i >= 0; i--) {
            int j = column - 1;

            //Binary search
            if (binaryMatrix[i][j] == 1) {
                int lo = 0;
                int hi = j;

                while (hi > lo) {
                    int mid = (lo + hi) /2;

                    if (binaryMatrix[i][mid] == 1) {
                        if (mid-1 >= 0 && binaryMatrix[i][mid-1] != 1 && mid < result) {
                            result = mid;
                            break;
                        }
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                if (lo < result && binaryMatrix[i][lo] == 1) {
                    result = lo;
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {

        LeftmostColumnwithAOne ob = new LeftmostColumnwithAOne();

        System.out.println(ob.leftMostColumnWithOne(new int[][] {{0,0}, {1,1}}));

        System.out.println(ob.leftMostColumnWithOne(new int[][] {{0,0,0,1},
                {0,0,1,1},
                {0,1,1,1},
                {0,0,1,1},
                {0,0,0,0}}));

    }

}


