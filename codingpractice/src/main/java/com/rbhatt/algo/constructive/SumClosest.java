package com.rbhatt.algo.constructive;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by rbhatt22 on 1/3/20.
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 target = -1 and nums = [-3, 2 , 1, 0, -2]
 (-3, 2, 1) = 0


 {-4, -1, 1, 2}
 target = 1

 sum = -3
 difference = 1 - -3 = 4
 {-4, -1, 2}

 sum = -1
 differnce = 1 - -1 = 2
 {-4, 1, 2}

 sum = 2
 difference = 1 - 2 = -1 = 1
 {-1, 1, 2}


 */
public class SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = 0 ;
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l = nums.length;

        for (int i = 0; i < l - 2; i++) {
            int low = i + 1;
            int high = l - 1;

            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < closestSum) {
                    closestSum = Math.abs(target - sum);
                    result = sum;
                }
                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                } else {
                    result = sum;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SumClosest ob = new SumClosest();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println((ob.threeSumClosest(nums, target)));

        int[] nums1 = {-3, 2 , 1, 0, -2};
        int target1 = -1;

        System.out.println((ob.threeSumClosest(nums1, target1)));

    }

}
