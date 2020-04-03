package com.rbhatt.linkedlist;

//LinkedList
//Two Pointer

//Leetcode question # 141

//Can you solve it using O(1) (i.e. constant) memory?
//This problem can be solved using keeping track of visitd nodes. But that will use O(n) memory.
//To solve this problem using O(1) we have to use slow and fast pointer.
//Use of slow and fast pointer is - Floyd's Tortoise and Hare algorithm.
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {

            if (fast.val == slow.val) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {

        LinkedListCycle ob = new LinkedListCycle();

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(ob.hasCycle(head));

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);

        head1.next = node11;
        node11.next = head1;

        System.out.println(ob.hasCycle(head1));

        ListNode head2 = new ListNode(1);

        System.out.println(ob.hasCycle(head2));
    }

}
