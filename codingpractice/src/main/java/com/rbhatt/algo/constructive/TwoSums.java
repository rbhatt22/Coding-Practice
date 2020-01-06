package com.rbhatt.algo.constructive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatt22 on 1/3/20.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 */
public class TwoSums {

    //Time complexity = O(n^2)
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }

        return result;
    }


    public int[] twoSumAlt(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {

        TwoSums ob = new TwoSums();

        int[] nums = {2,7,11,15};
        int target = 9;


        System.out.println(Arrays.toString(ob.twoSum(nums, target)));

        System.out.println(Arrays.toString(ob.twoSumAlt(nums, target)));

    }

}
