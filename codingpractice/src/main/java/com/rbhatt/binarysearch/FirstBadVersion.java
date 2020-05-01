package com.rbhatt.binarysearch;

//Binary Search
//Leetcode question # 278
public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        int mid;

        if (!isBadVersion(end)) {
            return 0;
        }

        while (start < end) {

            mid = start + (end - start)/2;

            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    //Wrote for testing
    public boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        } else {
            return false;
        }
    }

}
