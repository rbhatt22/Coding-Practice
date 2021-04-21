package com.rbhatt.array;

/**
 * Given page numbers in array. {1,2,3,4,10,15,16}. Print them in 1-4; 10; 15-16.
 * Asked during TrueMotion interview.
 *
 */
public class PageNumbers {

    public void pageCoverter(int[] arr) {

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                start = arr[i];
                end = arr[i];
            } else {

                if ((arr[i] -1) == end) {
                    end = arr[i];
                } else {
                    if (start == end) {
                        System.out.println(start);
                    } else {
                        System.out.println(start + "-" + end);
                    }

                    start = arr[i];
                    end = arr[i];
                }
            }

        }
        if (start == end) {
            System.out.println(start);
        } else {
            System.out.println(start + "-" + end);
        }

    }

    public static void main(String[] args) {

        PageNumbers ob = new PageNumbers();
        int[] arr = {1,2,3,4,10,15,16};
        ob.pageCoverter(arr);

    }

}
