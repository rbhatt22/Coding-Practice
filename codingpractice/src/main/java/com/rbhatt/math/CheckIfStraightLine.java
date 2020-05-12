package com.rbhatt.math;

//Math
//Leetcode question # 1232
public class CheckIfStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        int m = coordinates.length;

        if (m == 2) {
            return true;
        }

        //slop between first two points
        double slop = (double)(coordinates[0][1] - coordinates[1][1])/(coordinates[0][0] - coordinates[1][0]);

        for (int i = 2; i < m; i++) {

            if ((double)(coordinates[i-1][1] - coordinates[i][1])/(coordinates[i-1][0] - coordinates[i][0]) != slop) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        CheckIfStraightLine ob = new CheckIfStraightLine();

        int[][] a1 = new int[4][4];
        a1[0][0] = 1; a1[0][1] = 1;
        a1[1][0] = 2; a1[1][1] = 2;
        a1[2][0] = 3; a1[2][1] = 3;
        a1[3][0] = 4; a1[3][1] = 4;

        System.out.println(ob.checkStraightLine(a1));

        int[][] a2 = new int[4][4];
        a2[0][0] = 1; a2[0][1] = 2;
        a2[1][0] = 2; a2[1][1] = 3;
        a2[2][0] = 3; a2[2][1] = 4;
        a2[3][0] = 4; a2[3][1] = 5;

        System.out.println(ob.checkStraightLine(a2));

        int[][] a3 = new int[5][5];
        a3[0][0] = -1; a3[0][1] = 1;
        a3[1][0] = -6; a3[1][1] = -4;
        a3[2][0] = -6; a3[2][1] = 2;
        a3[3][0] = -1; a3[3][1] = -2;
        a3[4][0] = 0; a3[4][1] = -4;

        System.out.println(ob.checkStraightLine(a3));

    }

}
