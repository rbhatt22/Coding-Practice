package com.rbhatt.dynamicprogramming;

/**
 * Created by rbhatt22 on 8/11/21.
 * Leetcode problem # 264
 *
 * Dynamic Programming
 */
public class UglyNumbers {

    public int nthUglyNumber(int n) {

        int[] array = new int[n];

        array[0] = 1;

        int pointer_2 = 0;
        int pointer_3 = 0;
        int pointer_5 = 0;

        int i = 1;

        while (i < n) {

            int value_2 = array[pointer_2] * 2;
            int value_3 = array[pointer_3] * 3;
            int value_5 = array[pointer_5] * 5;

            if (value_2 < value_3 && value_2 < value_5) {
                if (array[i-1] != value_2) {
                    array[i] = value_2;
                    i++;
                }
                pointer_2++;
            } else if (value_3 < value_5) {
                if (array[i-1] != value_3) {
                    array[i] = value_3;
                    i++;
                }
                pointer_3++;
            } else {
                if (array[i-1] != value_5) {
                    array[i] = value_5;
                    i++;
                }
                pointer_5++;
            }

        }

        return array[n-1];
    }

    public static void main(String[] args) {

        UglyNumbers ob = new UglyNumbers();
        System.out.println(ob.nthUglyNumber(1));
        System.out.println(ob.nthUglyNumber(8));
        System.out.println(ob.nthUglyNumber(10));
        System.out.println(ob.nthUglyNumber(11));
    }
}
