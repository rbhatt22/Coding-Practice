package com.rbhatt.binarysearch;

//binary search
//Leetcode question # 540
public class SingleElementInaSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start)/2;

        while (nums[start] != nums[mid] || nums[end] != nums[mid]) {

            if (nums[mid - 1] == nums[mid]) {
                if ((end - (mid+1)) % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 2;
                }
            } else if (nums[mid + 1] == nums[mid]) {
                if (((mid-1) - start) % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid + 2;
                }
            } else {
                return nums[mid];
            }

            mid = start + (end - start)/2;

        }

        if (nums[start] == nums[mid]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }

    public static void main(String[] args) {

        SingleElementInaSortedArray ob = new SingleElementInaSortedArray();

        System.out.println(ob.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8} ));

        System.out.println(ob.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));

        System.out.println(ob.singleNonDuplicate(new int[] {1,1,2,3,3}));

    }
}
