package com.rbhatt.array;

//Array
//Two Pointer

//Leetcode question # 287

/*
This is classic Linked List Cycle problem.
Optimal way to solve this is using Floyd's Tortoise and Hare solution. In other terms using slow and fast pointer.

Basic idea is that if slow and fast pointer meets at one point then there is a cycle or duplicate number in this case.
And then we have to find start of the cycle or duplicate number. To find it we have to take another pointer and use slow pointer.
Keep moving both one step at a time. And where pointer and slow meets that is start of cycle or duplicate number.

*/
public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        //starting point of slow and fast
        int slow = nums[0];
        int fast = nums[0];

        //First part to find if there is a cycle.
        // Now here it is given that there is atleast one duplicate so slow and fast going to point to same digit at some point.

        //Doing first step outside loop so loop doesn't end at first step
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[nums[fast]];

        }

        //When execution comes here we have determined that there is a cycle.
        //Slow and Fast met a meeting point. Now we need to find start of cycle or duplicate number in this case.

        int pointer1 = nums[0];

        while (pointer1 != slow) {

            pointer1 = nums[pointer1];
            slow = nums[slow];

        }

        return slow;
    }

    public static void main(String[] args) {

        FindDuplicate ob = new FindDuplicate();

        System.out.println(ob.findDuplicate(new int[] {1,3,4,2,2}));

        System.out.println(ob.findDuplicate(new int[] {3,1,3,4,2}));

        System.out.println(ob.findDuplicate(new int[] {2,2,2,2,2}));

        System.out.println(ob.findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}));

    }
}
