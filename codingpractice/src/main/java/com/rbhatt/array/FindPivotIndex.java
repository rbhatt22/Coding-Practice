package com.rbhatt.array;

//Array
//Leetcode question # 724
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int sum = 0;

        if (nums.length < 3) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0) {
                right += nums[i-1];
            }

            int left = sum - (nums[i] + right);
            if (right == left) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FindPivotIndex ob = new FindPivotIndex();

        System.out.println(ob.pivotIndex(new int[] {1,7,3,6,5,6}));

        System.out.println(ob.pivotIndex(new int[] {-1,-1,-1,0,1,1}));

        System.out.println(ob.pivotIndex(new int[] {-1,-1,0,1,1,-2}));
    }

}
