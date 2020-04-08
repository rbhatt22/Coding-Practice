package com.rbhatt.hashtable;

import java.util.HashMap;
import java.util.Map;

//Hashtable

//Leetcode 30 day challenge question.
public class CountingElements {

    public int countElements(int[] arr) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Integer key : map.keySet()) {

            if (map.containsKey(key + 1)) {
                count += map.get(key);
            }

        }

        return count;

    }

    public static void main(String[] args) {

        CountingElements ob = new CountingElements();

        System.out.println(ob.countElements(new int[] {1,2,3}));

        System.out.println(ob.countElements(new int[] {1,1,3,3,5,5,7,7}));

        System.out.println(ob.countElements(new int[] {1,3,2,3,5,0}));

        System.out.println(ob.countElements(new int[] {1,1,2,2}));

        System.out.println(ob.countElements(new int[] {1,1,2}));

    }

}
