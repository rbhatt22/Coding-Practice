package com.rbhatt.twopointer;

import java.util.Arrays;

//String
//two pointer
//Leetcode question # 344
public class ReverseString {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        ReverseString ob = new ReverseString();

        char[] s1 = new char[] {'h', 'e', 'l', 'l', 'o'};
        ob.reverseString(s1);
        System.out.println(Arrays.toString(s1));

        char[] s2 = new char[] {'R', 'U', 'T', 'V', 'I', 'J'};
        ob.reverseString(s2);
        System.out.println(Arrays.toString(s2));

        char[] s3 = new char[] {'A', 'B'};
        ob.reverseString(s3);
        System.out.println(Arrays.toString(s3));

    }
}
