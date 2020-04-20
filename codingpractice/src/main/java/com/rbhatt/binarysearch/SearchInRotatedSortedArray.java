package com.rbhatt.binarysearch;

//Array
//Binary Search

//Leetcode question # 33
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = hi + lo / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        if (lo < nums.length && nums[lo] == target) {
            return lo;
        }

        return -1;
    }

    public static void main(String[] args) {

        SearchInRotatedSortedArray ob = new SearchInRotatedSortedArray();

        System.out.println(ob.search(new int[] {4,5,6,7,0,1,2}, 0));

        System.out.println(ob.search(new int[] {4,5,6,7,0,1,2}, 3));

        System.out.println(ob.search(new int[] {4,5,6,0,1,2}, 2));

        System.out.println(ob.search(new int[] {}, 0));

        System.out.println(ob.search(new int[] {1,3}, 1));

    }

}
