package com.rbhatt.binarysearch;

//Array
//Binary Search

import java.util.*;

//Leetcode question # 81
// This is variant of question SearchInRotatedSortedArray.
//Only difference is that here duplicates are allowed.
//Same solution works for both.
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if (nums[mid] == target) {
                return true;
            }

            //left side is sorted
            if (nums[lo] < nums[mid]) {
                //if target is in right side
                if (target < nums[lo] || target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[lo] > nums[mid]) { //if right side sorted
                //if target is in left side
                if (target < nums[mid] || target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                lo++;
            }

        }

        return false;

    }

    public static void main(String[] args) {

        SearchInRotatedSortedArray2 ob = new SearchInRotatedSortedArray2();

        System.out.println(ob.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));

        System.out.println(!ob.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));

        System.out.println(ob.search(new int[] {1,3,1,1,1}, 3));

        System.out.println(!ob.search(new int[] {}, 0));

        System.out.println(ob.search(new int[] {3,1}, 1));

        System.out.println(ob.search(new int[] {3,1}, 3));

        System.out.println(ob.search(new int[] {3,1,1,1,1}, 3));

        System.out.println(ob.search(new int[] {1, 1}, 1));

        System.out.println(ob.search(new int[] {1,2,3,0,1,1}, 3));

        System.out.println(!ob.search(new int[] {1,3}, 0));

        System.out.println(!ob.search(new int[] {3,1}, 2));




    }

}
