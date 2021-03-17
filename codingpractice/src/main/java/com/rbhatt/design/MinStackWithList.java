package com.rbhatt.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode question # 155 - Min Stack
 * Stack, Design
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStackWithList {

    List<Integer> stackList = new ArrayList<>();
    List<Integer> minList = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        stackList.add(x);
        min = Math.min(x, min);
        minList.add(min);
    }

    public void pop() {
        if (stackList.isEmpty()) {
            return;
        }
        stackList.remove(stackList.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public Integer getMin() {
        if (minList.isEmpty()) {
            return null;
        }
        return minList.get(minList.size() - 1);
    }

    public Integer top() {
        if (stackList.isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    public static void main(String[] args) {

        MinStackWithList ob = new MinStackWithList();

        /*ob.push(5);
        ob.push(10);
        ob.push(2);
        System.out.println("Min: " + ob.min());
        System.out.println("Top: " + ob.top());
        ob.pop();
        System.out.println("Min: " + ob.min());
        System.out.println("Top: " + ob.top());*/

        System.out.println(ob.getMin());
        ob.push(2147483646);
        ob.push(2147483646);
        ob.push(2147483647);
        System.out.println(ob.top());
        ob.pop();
        System.out.println(ob.getMin());
        ob.pop();
        System.out.println(ob.getMin());
        ob.pop();
        ob.push(2147483647);
        System.out.println(ob.top());
        System.out.println(ob.getMin());
        ob.push(-2147483648);
        System.out.println(ob.top());
        System.out.println(ob.getMin());
        ob.pop();
        System.out.println(ob.getMin());
    }

}
