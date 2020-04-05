package com.rbhatt.array;

import java.util.Arrays;

//Array

//Leetcode question # 283

// 1. You must do this in-place without making a copy of the array.
// 2. Minimize the total number of operations.
public class MoveZeros {

    //This solution is without using two pointers.
    // It works fine but it takes more time than two pointer solution.
    public void moveZeroes(int[] nums) {

        int i = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] == 0) {
                length = zeroFound(nums, i, length);
            } else {
                i++;
            }
        }

    }

    public int zeroFound(int[] nums, int index, int length) {

        for (int i = index; i < length - 1; i++) {

            nums[i] = nums[i + 1];

        }

        nums[length - 1] = 0;
        return length - 1;

    }

    //two pointer solution
    //Performs better than above solution.
    //Time complexity: O(n)
    public void moveZeros2(int[] nums) {

        int nonZeroPointer = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nonZeroPointer += 1;
                nums[nonZeroPointer] = nums[i];
            }
        }

        for (int i = nonZeroPointer + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {

        MoveZeros ob = new MoveZeros();

        int[] a = new int[] {0 , 1, 0, 3, 12};
        ob.moveZeroes(a);
        System.out.println(Arrays.toString(a));

        int[] b = new int[] {0 , 0, 1, 3, 12};
        ob.moveZeroes(b);
        System.out.println(Arrays.toString(b));

        int[] c = new int[] {1, 2, 12, 0, 0};
        ob.moveZeroes(c);
        System.out.println(Arrays.toString(c));

        /////

        int[] a2 = new int[] {0 , 1, 0, 3, 12};
        ob.moveZeros2(a2);
        System.out.println(Arrays.toString(a2));

        int[] b2 = new int[] {0 , 0, 1, 3, 12};
        ob.moveZeros2(b2);
        System.out.println(Arrays.toString(b2));

        int[] c2 = new int[] {1, 2, 12, 0, 0};
        ob.moveZeros2(c2);
        System.out.println(Arrays.toString(c2));

    }

}
