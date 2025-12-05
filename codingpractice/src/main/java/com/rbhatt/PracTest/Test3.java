package com.rbhatt.PracTest;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by rbhatt22 on 7/29/20.
 */
public class Test3 {
    public static int count = 0;

    int countUniqueOpt(String[] arr) {

        Set<String> resultList = new HashSet<>();

        backtracking(arr, 3, resultList, new ArrayList<>());

        return resultList.size();
    }

    void backtracking(String[] arr, int k, Set<String> resultList, List<Integer> indexList) {

        if (indexList.size() == k) {
            String tempString = arr[indexList.get(0)] + arr[indexList.get(1)] + arr[indexList.get(2)];
            resultList.add(tempString);
        } else {

            for (int i = 0; i < arr.length; i++) {
                if (!indexList.contains(i)) {
                    indexList.add(i);

                    backtracking(arr, k, resultList, indexList);

                    indexList.remove(indexList.size() - 1);
                }
            }
        }
    }


    int countUnique(String [] arr)
    {
        Set<String> s = new TreeSet<>();
        for (int i = 0; i<arr.length; i++)
        {
            for (int j = 0; j<arr.length; j++)
            {
                for (int k = 0; k<arr.length; k++)
                {
                    count++;
                    if (i!=j && j != k && i!=k)
                        s.add((arr[i] +""+arr[j]+""+arr[k]));
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {

        Test3 ob = new Test3();
        String[] arr = new String[] {"1", "1", "1", "2"};
        Long startTime = System.currentTimeMillis();
        System.out.println(ob.countUniqueOpt(arr));
        Long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime));

        System.out.println("count: " + count);
    }




}
