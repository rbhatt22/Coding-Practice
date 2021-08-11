package com.rbhatt.dynamicprogramming;

/**
 * Created by rbhatt22 on 8/10/21.
 * Leetcode question # 198
 *
 * Dynamic Programming
 */
public class HouseRobber {

    public int rob(int[] nums) {

        int[] m = new int[nums.length + 1];

        m[0] = 0;
        m[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int value = nums[i];

            m[i+1] = Math.max(m[i], value + m[i-1]);

        }

        return m[nums.length];
    }

    public int robOptimized(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];

        for (int num : nums) {

            int temp = prev1;

            prev1 = Math.max(prev1, num + prev2);

            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {

        HouseRobber ob = new HouseRobber();

        int[] rob1 = {1,2,3,1};

        System.out.println(ob.robOptimized(rob1));

        int[] rob2 = {2,7,9,3,1};

        System.out.println(ob.robOptimized(rob2));

    }

}
