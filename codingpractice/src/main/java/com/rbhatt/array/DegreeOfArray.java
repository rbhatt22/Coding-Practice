package com.rbhatt.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rbhatt22 on 1/10/20.
 * Leetcode question # 697 - Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:

 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.

 Time complexity : O(n)
 */
public class DegreeOfArray {

    //32ms solution. Uses 3 Maps.
    public int findShortestSubArray(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (freq.containsKey(value)) {
                freq.put(value, freq.get(value)+1);
                end.put(value, i);
            } else {
                freq.put(value, 1);
                start.put(value, i);
                end.put(value, i);
            }
        }

        int maxFreq = freq.values().stream().max(Comparator.naturalOrder()).get();

        List<Integer> maxFreqKeys = freq.entrySet().stream().filter(f -> f.getValue() == maxFreq).map(Map.Entry::getKey).collect(Collectors.toList());

        for (Integer degree : maxFreqKeys) {
            int temp = end.get(degree) - start.get(degree) + 1;
            if (temp < result) {
                result = temp;
            }
        }

        return result;
    }

    //22ms solution/ Uses 2 Maps. Saves insert and retrieval from 3rd map
    public int findShortestSubArrayAlt(int[] nums) {
        int result = Integer.MAX_VALUE;
        int maxFreq = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (!freq.containsKey(nums[i])) {
                freq.put(value, 1);
                start.put(value, i);

                //this handles if array has only 1 element. or if degree of an array is 1
                if (maxFreq == 0) {
                    maxFreq = 1;
                    result = 1;
                }
            } else {
                int currentFreq = freq.get(value) + 1;
                freq.put(value, currentFreq);
                if (currentFreq > maxFreq) {
                    maxFreq = currentFreq;
                    result = i - start.get(value) + 1;
                } else if (currentFreq == maxFreq) {
                    result = Math.min(result, i - start.get(value) + 1);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 1};
        int[] b = {1,2,2,3,1,4,2};
        int[] c = {1, 2, 3};

        DegreeOfArray ob = new DegreeOfArray();
        System.out.println(ob.findShortestSubArray(a));

        System.out.println(ob.findShortestSubArray(b));

        System.out.println(ob.findShortestSubArray(c));
    }

}
