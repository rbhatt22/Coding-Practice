package com.rbhatt.design;

/**
 * Leetcode question # 155 - Min Stack
 * Stack, Design
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {

    private Node head;

    public void push(int x) {

        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        MinStack ob = new MinStack();

        ob.push(5);
        ob.push(10);
        ob.push(2);
        System.out.println("Min: " + ob.min());
        System.out.println("Top: " + ob.top());
        ob.pop();
        System.out.println("Min: " + ob.min());
        System.out.println("Top: " + ob.top());
    }

}
