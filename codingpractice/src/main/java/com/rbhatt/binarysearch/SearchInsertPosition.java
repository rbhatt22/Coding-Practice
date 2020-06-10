package com.rbhatt.binarysearch;


//Array
//Binary search
//Leetcode question # 35
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;
        int mid; // = lo + ((hi - lo)/2);

        if (target < nums[lo]) {
            return 0;
        }
        if (target > nums[hi]) {
            return hi+1;
        }

        while (lo < hi) {

            mid = lo + ((hi - lo)/2);

            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return lo;

    }

    public static void main(String[] args) {

        SearchInsertPosition ob = new SearchInsertPosition();

        System.out.println(ob.searchInsert(new int[] {1,3,5,6}, 5));

        System.out.println(ob.searchInsert(new int[] {1,3,4,5}, 2));

        System.out.println(ob.searchInsert(new int[] {1,3,5,6}, 7));

        System.out.println(ob.searchInsert(new int[] {2,3,4,5}, 1));

    }

}
