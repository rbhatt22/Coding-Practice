package com.rbhatt.math;

//Math
//HashSet

import java.util.HashSet;
import java.util.Set;

//Leetcode question # 202
public class HappyNumber {

    public boolean isHappy(int n) {

        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);

        return recursion(n, set);

    }

    public boolean recursion(int num, Set<Integer> set) {

        String s = String.valueOf(num);
        int length = s.length();
        int temp = 0;

        for (int i = 0; i < length; i++) {

            Integer a = Integer.parseInt(s.substring(i, i+1));
            temp = temp + a*a;

        }

        if (temp == 1) {
            return true;
        } else {
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
            return recursion(temp, set);
        }
    }

    public static void main(String[] args) {

        HappyNumber ob = new HappyNumber();

        System.out.println(ob.isHappy(19));

        System.out.println(ob.isHappy(18));

        System.out.println(ob.isHappy(1));
    }

}
