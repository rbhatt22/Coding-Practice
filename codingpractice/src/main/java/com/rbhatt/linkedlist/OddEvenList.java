package com.rbhatt.linkedlist;

//LinkedList
//Leetcode question # 328
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode last;
        ListNode current = head;
        int i = 0;

        while (current.next != null) {
            current = current.next;
            i++;
        }

        if (i == 1) {
            return head;
        }

        last = current;
        current = head;

        for (int j = 0; j < (i+1)/2; j++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = null;
            last.next = temp;
            last = temp;

            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        OddEvenList ob = new OddEvenList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next =  l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(ob.oddEvenList(null));

    }

}
