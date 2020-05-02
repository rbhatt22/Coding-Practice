package com.rbhatt.string;

import java.util.Map;
import java.util.HashMap;

//String
//Bit operation
//Leetcode question # 771
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        //One line solution
        //return S.replaceAll("[^" + J + "]", "").length();

        //my intuitive solution
        int count = 0;
        char[] jewels = J.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : jewels) {
            map.put(c, 1);
        }

        char[] stones = S.toCharArray();

        for (char s : stones) {
            if (map.containsKey(s)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        JewelsAndStones ob = new JewelsAndStones();

        System.out.println(ob.numJewelsInStones("aA", "aAAbbbb"));

        System.out.println(ob.numJewelsInStones("z", "ZZ"));

    }

}
