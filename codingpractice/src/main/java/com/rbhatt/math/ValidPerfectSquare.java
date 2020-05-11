package com.rbhatt.math;

//Math
//Binary Search
//Leetcode question # 367
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        int start = 0;
        int end = num;

        while(start <= end) {

            int mid = start + (end - start)/2;

            if ((long) mid * mid == num) {
                return true;
            }

            if ((long)mid*mid > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        ValidPerfectSquare ob = new ValidPerfectSquare();

        System.out.println(ob.isPerfectSquare(8));

        System.out.println(ob.isPerfectSquare(16));

        System.out.println(ob.isPerfectSquare(2147483647));

    }

}
