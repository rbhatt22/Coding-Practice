package com.rbhatt.twopointer;

public class NeedleInHaystack {

    public int strStr(String haystack, String needle) {
        int result = -1;
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength == 0) {
            return 0;
        }

        char needleFirstChar = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {

            char c = haystack.charAt(i);
            if (c == needleFirstChar) {
                if (i+needleLength <= haystackLength && haystack.substring(i, i+needleLength).equals(needle)) {
                    return i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        NeedleInHaystack ob = new NeedleInHaystack();

        System.out.println(ob.strStr("hello", "ll"));

        System.out.println(ob.strStr("aaaaa", "bba"));

        System.out.println(ob.strStr("aaa", "aaaa"));

        System.out.println(ob.strStr("a", "a"));
    }

}
