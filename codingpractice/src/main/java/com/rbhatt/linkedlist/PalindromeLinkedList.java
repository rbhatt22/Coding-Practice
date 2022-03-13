package com.rbhatt.linkedlist;

import java.util.Stack;

/**
 * Question # 234
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Solution # 1 - using stack. Coded below. Time complexity - O(n); Space complexity O(n)
 * Solution # 2 - Reverse second half of the input and then compare with first half using two pointers. This will be O(n) time complexity and O(1) space
 */
public class PalindromeLinkedList {

    //Find size on linkedlist
    //Find if size is odd or even. Based on that decide left and right side.
    //if left and right side are same or not
    public boolean isPalindromeWithStack(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        //false if no node or only one node
        if (head.next == null) {
            return true;
        }

        ListNode currentNode = head;

        //find size of the LinkedList
        int size = 0;

        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }
        //for last node
        size++;

        //find middle node
        int halfSize;
        boolean isOdd = false;

        if (size % 2 == 0) {
            halfSize = size / 2;
        } else {
            halfSize = (size - 1) / 2;
            isOdd = true;
        }

        currentNode = head;

        while(currentNode.next != null) {

            if (halfSize > 0) {
                stack.push(currentNode.val);
                halfSize--;
            } else {
                //skipping middle node when size is odd
                if (isOdd) {
                    isOdd = false;
                } else {
                    if (currentNode.val != stack.pop()) {
                        return false;
                    }
                }
            }

            currentNode = currentNode.next;

        }

        //for last node value
        if (currentNode.val != stack.pop()) {
            return false;
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromeLinkedList ob = new PalindromeLinkedList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.val = 1;
        l2.val = 2;
        l3.val = 1;
        l4.val = 1;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(ob.isPalindromeWithStack(l1));

    }

}
