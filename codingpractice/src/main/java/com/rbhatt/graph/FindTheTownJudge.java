package com.rbhatt.graph;

import java.util.*;

//Array
//Graph (updated solution)
//Leetcode question # 997
public class FindTheTownJudge {

    //with graph
    public int findJudge(int N, int[][] trust) {

        int result = -1;

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            List<Integer> list;

            if (adjacencyList.containsKey(trust[i][0])) {
                list = adjacencyList.get(trust[i][0]);
            } else {
                list = new ArrayList<>();
            }

            list.add(trust[i][1]);
            adjacencyList.put(trust[i][0], list);
        }

        for (int i = 1; i <= N; i++) {

            if (!adjacencyList.containsKey(i)) {
                if (result == -1) {
                    result = i;
                } else {
                    result = -1;
                }
            }

        }

        if (result != -1) {
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                if (!entry.getValue().contains(result)) {
                    result = -1;
                    break;
                }
            }
        }

        return result;
    }

    /*public int findJudge(int N, int[][] trust) {

        int result = -1;
        Set<Integer> cantBeJudge = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        if (trust.length == 0) {
            return 1; // judge is the only one in town.
        }

        for (int i = 0; i < trust.length; i++) {

            Set<Integer> set;

            if (!map.containsKey(trust[i][1])) {
                set = new HashSet<>();
                set.add(trust[i][0]);
                cantBeJudge.add(trust[i][0]);
                map.put(trust[i][1], set);
            } else {
                set = map.get(trust[i][1]);
                set.add(trust[i][0]);
                cantBeJudge.add(trust[i][0]);
                map.put(trust[i][1], set);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {

            if (!cantBeJudge.contains(entry.getKey()) && entry.getValue().size() == N-1) {
                result = entry.getKey();
            }

        }

        return result;
    }*/

    public static void main(String[] args) {

        FindTheTownJudge ob = new FindTheTownJudge();

        System.out.println(ob.findJudge(2, new int[][] {{1,2}} ));

        System.out.println(ob.findJudge(3, new int[][] {{1,3}, {2,3}} ));

        System.out.println(ob.findJudge(3, new int[][] {{1,3}, {2,3}, {3,1}} ));

        System.out.println(ob.findJudge(3, new int[][] {{1,2}, {2,3}}));

        System.out.println(ob.findJudge(4, new int[][] {{1,3}, {1,4}, {2,3}, {2,4}, {4,3}} ));

        System.out.println(ob.findJudge(1, new int[][] {} ));

    }

}
