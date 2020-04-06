package com.rbhatt.linkedlist;

//Linked List

//Leetcode question # 203

public class RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode current = temp;

        while (current.next != null) {

            if (current.next.val == val) {

                current.next = current.next.next;

            } else {

                current = current.next;

            }
        }

        return temp.next;
    }

    public static void main(String[] args) {

        RemoveLinkedListElement ob = new RemoveLinkedListElement();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result = ob.removeElements(head, 6);
        System.out.println(result);

        ListNode head2 = new ListNode(1);

        ListNode result2 = ob.removeElements(head2, 1);
        System.out.println(result2);

        ListNode head3 = new ListNode(1);
        ListNode node11 = new ListNode(1);

        head3.next = node11;

        ListNode result3 = ob.removeElements(head3, 1);
        System.out.println(result3);
    }

}
