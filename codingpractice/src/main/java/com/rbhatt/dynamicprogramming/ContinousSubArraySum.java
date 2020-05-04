package com.rbhatt.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

//dynamic programming
//Leetcode question # 523
public class ContinousSubArraySum {

    //Check is given array has a subarray whose sum is multiple of k
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            if (k != 0) {
                sum = sum % k;
            }

            if (dp.containsKey(sum)) {

                int distance = i - dp.get(sum);
                if (distance > 1) {
                    return true;
                }
            } else {

                dp.put(sum, i);

            }

        }
        return false;
    }

    public static void main(String[] args) {

        ContinousSubArraySum ob = new ContinousSubArraySum();

        System.out.println(ob.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));

        System.out.println(ob.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 6));

        System.out.println(ob.checkSubarraySum(new int[] {23, 1}, 6));

        System.out.println(ob.checkSubarraySum(new int[] {23, 2, 0, 0, 7} , 0));

    }

}
