package com.rbhatt.greedy;

//Array
//Greedy
//Leetcode question # 55
public class JumpGame {

    public boolean canJump(int[] nums) {

        int[] b = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            b[i] = i + nums[i];
        }

        if (nums.length == 1) {
            return true;
        }

        if (b[0] == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i -1; j >= 0; j--) {
                    if (b[j] > i  || b[j] >= nums.length-1) {
                        break;
                    }
                    if (j==0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        JumpGame ob = new JumpGame();

        System.out.println(ob.canJump(new int[] {0,1}));

        System.out.println(ob.canJump(new int[] {3,2,1,0,4}));

        System.out.println(ob.canJump(new int[] {1,0,2,3,4}));

        System.out.println(ob.canJump(new int[] {1,2,3,4}));

        System.out.println(ob.canJump(new int[] {2,0,0}));

    }
}
