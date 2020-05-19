package com.rbhatt.stack;

import java.util.Stack;

//design
//stack
//Leetcode question # 901
public class StockSpanner {

    public class StockSpan {

        private int price;
        private int span;

        StockSpan(int price, int span) {
            this.price = price;
            this.span = span;
        }

    }

    Stack<StockSpan> stack;

    /*List<Integer> stockPrice;
    int previousDayPrice;
    int maxPrice;*/

    public StockSpanner() {

        stack = new Stack<>();

        /*stockPrice = new ArrayList<>();
        previousDayPrice = 0;
        maxPrice = Integer.MIN_VALUE;*/

    }

    public int next(int price) {

        /*if (stack.size() == 0) {
            stack.push(new StockSpan(price, 1));
            return 1;
        }*/

        int span = 1;
        while(!stack.empty() && price >= stack.peek().price) {
            span += stack.pop().span;
        }

        stack.push(new StockSpan(price, span));

        return span;
    }

    /*public int next(int price) {

        if (stockPrice.size() == 0) {
            stockPrice.add(price);
            maxPrice = price;
            previousDayPrice = price;
            return 1;
        }

        if (price < previousDayPrice) {
            previousDayPrice = price;
            stockPrice.add(price);
            return 1;
        }

        if (price > maxPrice) {
            previousDayPrice = price;
            maxPrice = price;
            stockPrice.add(price);
            return stockPrice.size();
        }

        int span = 1;
        for (int i = stockPrice.size() - 1; i >= 0; i--) {
            if (price < stockPrice.get(i)) {
                break;
            }
            span++;
        }

        previousDayPrice = price;
        stockPrice.add(price);

        return span;
    }*/

    public static void main(String[] args) {

        StockSpanner ob = new StockSpanner();

        System.out.println(ob.next(100));
        System.out.println(ob.next(80));
        System.out.println(ob.next(60));
        System.out.println(ob.next(70));
        System.out.println(ob.next(60));
        System.out.println(ob.next(75));
        System.out.println(ob.next(85));

        System.out.println();
        StockSpanner ob1 = new StockSpanner();

        System.out.println(ob1.next(29));
        System.out.println(ob1.next(91));
        System.out.println(ob1.next(62));
        System.out.println(ob1.next(76));
        System.out.println(ob1.next(51));

    }

}
