package com.rbhatt.binarysearch;

//Array
//Binary Search

//Leetcode question # 153
//No duplicates
public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        int result;

        //Initializing result
        if (nums[lo] < nums[hi]) {
            result = nums[lo];
        } else {
            result = nums[hi];
        }

        //if size is 1 or 2 initialized value is the result
        if (nums.length <= 2) {
            return result;
        }

        while(lo < hi) {

            int mid = (lo + hi) / 2;

            if (nums[mid] < result) {
                result = nums[mid];
            }

            /*if (nums[mid] < nums[lo] && nums[mid] < nums[hi]) {
                return result;
            }*/

            if (mid == hi) {
                return result;
            } else if (mid == lo) {
                return result;
            }

            if (nums[hi] < nums[mid]) {
                if (nums[hi] < result) {
                    result = nums[hi];
                }
                lo = mid + 1;
            } else if (nums[lo] < nums[mid]) {
                if (nums[lo] < result) {
                    result = nums[lo];
                }
                hi = mid - 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        FindMinInRotatedSortedArray ob = new FindMinInRotatedSortedArray();

        System.out.println(ob.findMin(new int[] {3,4,5,1,2}));

        System.out.println(ob.findMin(new int[] {4,5,6,7,0,1,2}));

        System.out.println(ob.findMin(new int[] {2,1}));

        System.out.println(ob.findMin(new int[] {3,1,2}));

        System.out.println(ob.findMin(new int[] {2}));

        System.out.println(ob.findMin(new int[] {1,2,3,4,5}));

        System.out.println(ob.findMin(new int[] {5,1,2,3,4}));

    }

}
