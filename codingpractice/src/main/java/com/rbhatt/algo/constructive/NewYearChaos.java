package com.rbhatt.algo.constructive;

import java.util.Scanner;

/**
 * Created by rbhatt22 on 7/28/19.
 * HackerRankLink: https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

public class NewYearChaos {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int size = q.length;
        int[] tempA = new int[size];
        int moves = 0;
        for (int i =0; i < size -1; i++) {
            for (int j=0; j< size-i-1; j++) {
                if (q[j] > q[j+1]) {
                    int temp = q[j];
                    int tempV = tempA[temp-1];
                    tempA[temp-1] = tempV + 1;
                    q[j] = q[j+1];
                    q[j+1] = temp;
                    moves = moves + 1;
                }
            }
            if (isSorted(q)) {
                if (checkChaotic(tempA)) {
                    System.out.println("Too chaotic");
                    return;
                }
                System.out.println(moves);
                return;
            }
        }
        if (checkChaotic(tempA)) {
            System.out.println("Too chaotic");
            return;
        }

        System.out.println(moves);
    }

    static boolean checkChaotic(int[] q) {
        boolean isChaotic = false;
        int size = q.length;
        for (int i=0; i<size; i++) {
            if (q[i] >= 3) {
                isChaotic = true;
            }
        }
        return isChaotic;
    }

    static boolean isSorted(int[] q) {
        boolean isSorted = true;
        int size = q.length;
        for (int i=0; i<size; i++) {
            if(q[i] != i+1) {
                isSorted=false;
            }
        }
        return isSorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}
