package com.rbhatt.string;

import java.util.Map;
import java.util.HashMap;

//String
//Leetcode question # 387
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {

            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], i);
            } else {
                map.put(charArray[i], -1);
            }

        }

        if (map.isEmpty()) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < result) {
                result = entry.getValue();
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    //Easier and faster way to solve this.
    /*public int firstUniqChar(String s) {

        int[] array=new int[26];

        for (int i=0;i<s.length();i++)
        {
            array[s.charAt(i)-'a']++;
        }

        for (int k=0;k<s.length();k++)
        {
            if(array[s.charAt(k)-'a']==1)
            {
                return k;
            }
        }

        return -1;

    }*/

    public static void main(String[] args) {

        FirstUniqueCharacter ob = new FirstUniqueCharacter();

        System.out.println(ob.firstUniqChar("leetcode"));

        System.out.println(ob.firstUniqChar("loveleetcode"));

        System.out.println(ob.firstUniqChar("eeffgg"));

        System.out.println(ob.firstUniqChar(""));

        System.out.println(ob.firstUniqChar("a"));

        System.out.println(ob.firstUniqChar("aadadaad"));

    }

}
