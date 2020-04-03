package com.rbhatt.linkedlist;

//Linked List
//Two Pointer

//Leetcode question # 142

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
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null && fast != slow) {

            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode pointer = head;

        while (pointer != slow) {
            slow = slow.next;
            pointer = pointer.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        LinkedListCycle2 ob = new LinkedListCycle2();

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(ob.detectCycle(head));

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);

        head1.next = node11;
        //node11.next = head1;

        System.out.println(ob.detectCycle(head1));

        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(3);

        head2.next = node22;
        node22.next = node33;

        System.out.println(ob.detectCycle(head2));
    }

}
