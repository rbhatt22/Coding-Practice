package com.rbhatt.PracTest;

import java.util.Arrays;

//String
//Sliding window
//Leetcode question # 567
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        int[] arrayS1 = new int[26];
        int[] arrayS2 = new int[26];

        for (char c : s1.toCharArray()) {
            arrayS1[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {

            if (i >= s1.length()) {
                arrayS2[s2.charAt(i - s1.length()) - 'a']--;
            }

            arrayS2[s2.charAt(i) - 'a']++;

            if (Arrays.equals(arrayS1, arrayS2)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        PermutationInString ob = new PermutationInString();

        System.out.println(ob.checkInclusion("ab", "eidbaooo"));

        System.out.println(ob.checkInclusion("ab", "eidboaoo"));

        System.out.println(ob.checkInclusion("a", ""));

        System.out.println(ob.checkInclusion("", "a"));

    }

}
