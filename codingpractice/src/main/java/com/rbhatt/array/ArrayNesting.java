package com.rbhatt.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatt22 on 9/1/21.
 */
public class ArrayNesting {

    //This logic works but it takes more time.
    //Key here is that all elements part of one set will have same result.
    //Ex: 5 -> 6 -> 2 -> 0 -> 5
    //So, 5, 6, 2, 0 will have same result 4. so no need to calculate its result again.
    public int arrayNesting(int[] nums) {

        int result = -1;
        Set<Integer> set;

        for (int i = 0; i < nums.length; i++) {

            set = new HashSet<>();

            int setSize = -1;
            int temp = -1;


            while(setSize < set.size()) {
                if (temp < 0) {
                    temp = i;
                }

                temp = nums[temp];
                set.add(temp);
                setSize++;

            }

            if (setSize > result) {
                result = setSize;
            }

        }


        return result;
    }

    public int arrayNestingOptimized(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int tempResult = 0;
            int index = i;

            while (nums[index] != -1) {

                int temp = index;
                index = nums[index];
                nums[temp] = -1;
                tempResult++;

            }

            result = Math.max(result, tempResult);

        }

        return result;
    }

    public static void main(String[] args) {

        ArrayNesting ob = new ArrayNesting();

        int[] nums = {5,4,0,3,1,6,2};
        int[] nums1 = {1,2,0};

        System.out.println(ob.arrayNestingOptimized(nums1));

    }

}
