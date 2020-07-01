package com.rbhatt.array;

import java.util.Arrays;

//Array
//Leetcode question #
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int previousIndex = 0;

        while(i < nums.length) {
            if (nums[i] != nums[previousIndex]) {
                previousIndex++;
                nums[previousIndex] = nums[i];
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));
        return previousIndex + 1;
    }

    public static void main(String[] args) {

        RemoveDuplicatesSortedArray ob = new RemoveDuplicatesSortedArray();

        System.out.println(ob.removeDuplicates(new int[]{1, 1, 2}));

        System.out.println(ob.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
