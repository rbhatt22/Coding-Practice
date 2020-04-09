package com.rbhatt.linkedlist;

//Linked List

//Leetcode question # 876
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        //First iterate over linkedList to get the total number of nodes.
        //Find number of middle node. Do second iteration and stop at middle node.

        int n = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            n++;
        }

        current = head;
        int i = 0;
        while (i < n/2) {
            current = current.next;
            i ++;
        }

        return current;
    }

    public static void main(String[] args) {

        MiddleOfLinkedList ob = new MiddleOfLinkedList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ob.middleNode(a);

    }

}
