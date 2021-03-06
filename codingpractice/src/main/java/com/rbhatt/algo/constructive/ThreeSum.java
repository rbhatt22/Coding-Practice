package com.rbhatt.algo.constructive;

import java.util.*;

/**
 * Created by rbhatt22 on 1/3/20.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < l - 2; i++) {
            if (i == 0 || (nums[i] != nums [i - 1])) {
                int low = i + 1;
                int high = l - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    } else {
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    }
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {

        ThreeSum ob = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[] nums1 = {0, 0, 0, 0};

        System.out.println(ob.threeSum(nums));

        System.out.println(ob.threeSum(nums1));
    }

}
