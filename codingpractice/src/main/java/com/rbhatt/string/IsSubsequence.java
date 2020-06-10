package com.rbhatt.string;

//two pointer
//string
//Leetcode question # 392
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {

            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }

        }

        return sPointer == s.length();

    }

    public static void main(String[] args) {

        IsSubsequence ob = new IsSubsequence();

        System.out.println(ob.isSubsequence("abc", "ahbgdc"));

        System.out.println(ob.isSubsequence("axc", "ahbgdc"));

        System.out.println(ob.isSubsequence("aaaaaa","bbaaaa"));

    }

}
