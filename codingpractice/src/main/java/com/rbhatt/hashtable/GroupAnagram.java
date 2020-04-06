package com.rbhatt.hashtable;

import java.util.*;

//HashTable
//String

//Leetcode question # 49
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {

        String[] sArray = {"eat", "tea", "tan", "ate", "nat", "bat", "tana", "nata"};
        String[] sA2 = {"a", "a", "b", ""};

        GroupAnagram ob = new GroupAnagram();
        System.out.println(sArray);
        System.out.println(ob.groupAnagrams(sA2));

    }

}
