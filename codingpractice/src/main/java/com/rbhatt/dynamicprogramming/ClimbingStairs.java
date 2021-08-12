package com.rbhatt.dynamicprogramming;

/**
 * Created by rbhatt22 on 8/12/21.
 * Leetcode Problem # 70
 *
 * Dynamic Programming
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int result = 0;

        int prevStep = 2;
        int prevPrevStep = 1;

        for (int i = 3; i <= n; i++) {

            result = prevStep + prevPrevStep;

            prevPrevStep = prevStep;

            prevStep = result;

        }
        return result;
    }

    public static void main(String[] args) {

        ClimbingStairs ob = new ClimbingStairs();

        System.out.println(ob.climbStairs(3));
        System.out.println(ob.climbStairs(4));
        System.out.println(ob.climbStairs(5));

    }

}
