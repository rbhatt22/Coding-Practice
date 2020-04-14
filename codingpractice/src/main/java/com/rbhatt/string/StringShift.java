package com.rbhatt.string;

import com.rbhatt.PracTest.Solution;

//String

//Leetcode 30 day challenge problem
public class StringShift {

    public String stringShift(String s, int[][] shift) {

        int right = 0;
        int left = 0;

        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                left += shift[i][1];
            } else {
                right += shift[i][1];
            }
        }

        if (left == right) {
            return s;
        } else if (left > right) {
            left = left - right;
            return leftShift(s, left);
        } else {
            right = right - left;
            return rightShift(s, right);
        }

    }

    public String rightShift(String s, int n) {

        int t = n % s.length();
        if (t == 0) {
            return s;
        }

        //do right shift
        return s.substring(s.length() - t) + s.substring(0, s.length() - t);

    }

    public String leftShift(String s, int n) {

        int t = n % s.length();
        if (t == 0) {
            return s;
        }

        //do left shift
        return s.substring(t) + s.substring(0, t);

    }

    public static void main(String[] args) {

        StringShift ob = new StringShift();

        int[][] shift = new int[4][2];
        shift[0][0] = 1;
        shift[0][1] = 1;
        shift[1][0] = 1;
        shift[1][1] = 1;
        shift[2][0] = 0;
        shift[2][1] = 2;
        shift[3][0] = 1;
        shift[3][1] = 3;

        System.out.println(ob.stringShift("abcdefg", shift));

        int[][] shift1 = new int[2][2];
        shift1[0][0] = 0;
        shift1[0][1] = 1;
        shift1[1][0] = 1;
        shift1[1][1] = 2;

        System.out.println(ob.stringShift("abc", shift1));

        int[][] shift2 = new int[7][2];
        shift2[0][0] = 0;
        shift2[0][1] = 7;
        shift2[1][0] = 1;
        shift2[1][1] = 7;
        shift2[2][0] = 1;
        shift2[2][1] = 0;
        shift2[3][0] = 1;
        shift2[3][1] = 3;
        shift2[4][0] = 0;
        shift2[4][1] = 3;
        shift2[5][0] = 0;
        shift2[5][1] = 6;
        shift2[6][0] = 1;
        shift2[6][1] = 2;

        System.out.println(ob.stringShift("wpdhhcj", shift2));
    }

}
