package com.rbhatt.array;

import java.util.HashMap;
import java.util.Map;

//Array
//HashTable
//Dynamic programming

//Leetcode question # 560
//This can be solved by brute force approach with time complexity of O(n^2)
//But optimal approach is to use HashMap to save cumulative sum
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        /*Brute force approach
        for (int i = 0; i < nums.length; i++) {

            int tempSum = nums[i];
            if (tempSum == k) {
                result++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                tempSum = tempSum + nums[j];
                if (tempSum == k) {
                    result++;
                }
            }
        }*/

        return  result;
    }

    public static void main(String[] args) {

        SubArraySumEqualsK ob = new SubArraySumEqualsK();

        System.out.println(ob.subarraySum(new int[] {1,1,1}, 2));

        System.out.println(ob.subarraySum(new int[] {2,1,1,-2,0,2,1} , 2));

        System.out.println(ob.subarraySum(new int[] {2,4,5}, 2));

        System.out.println(ob.subarraySum(new int[] {1,1}, 2));
    }

}
