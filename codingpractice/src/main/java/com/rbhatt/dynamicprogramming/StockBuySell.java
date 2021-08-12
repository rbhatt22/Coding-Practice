package com.rbhatt.dynamicprogramming;

//Array
//Dynamic Programming
//Leetcode question # 121

//Solved using two pointer approach
/*
  Input: [7,1,5,3,6,4]
  Output: 5

  Input: [7,6,4,3,1]
  Output: 0
*/

public class StockBuySell {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int high = 0;
        int low = 0;

        for (int i = 0; i < prices.length; i++) {

           if (i == 0) {
               low = high = i;
           } else {
               if (prices[i] < prices[low]) {
                   low = i;
                   high = i;
               } else if (prices[i] > prices[low] && prices[i] > prices[high]) {
                   high = i;
                   if (high > low) {
                       if (prices[high] - prices[low] > profit) {
                           profit = prices[high] - prices[low];
                       }
                   }
               }
           }
        }
        return profit;
    }

    public static void main(String[] args) {

        StockBuySell ob = new StockBuySell();

        System.out.println(ob.maxProfit(new int[] {7,1,5,3,6,4}));

        System.out.println(ob.maxProfit(new int[] {1,2,3,4,5}));

        System.out.println(ob.maxProfit(new int[] {5,4,3,2,1}));

        System.out.println(ob.maxProfit(new int[] {5,1,4,2,3}));

        System.out.println(ob.maxProfit(new int[] {7,6,4,3,1}));

        System.out.println(ob.maxProfit(new int[] {2, 4, 1}));

    }


}
