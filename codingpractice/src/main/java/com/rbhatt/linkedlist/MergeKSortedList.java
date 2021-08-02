package com.rbhatt.linkedlist;

/**
 * Created by rbhatt22 on 7/28/21.
 * Linked List
 * Divide and Conquer
 * Merge Sort
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;

        for (int i = 0; i < lists.length; i++) {

            result = mergeTwoLists(lists[i], result);

        }

        return result;

    }

    private ListNode mergeTwoLists(ListNode listNode_m, ListNode listNode_n) {

        ListNode mergedList = null;
        ListNode returnList = null;

        while(listNode_m != null || listNode_n != null) {

            if (listNode_m == null) {
                if (mergedList == null) {
                    mergedList = new ListNode(listNode_n.val);
                    returnList = mergedList;
                } else {
                    mergedList.next = new ListNode(listNode_n.val);
                    mergedList = mergedList.next;
                }
                listNode_n = listNode_n.next;
            } else if (listNode_n == null) {
                if (mergedList == null) {
                    mergedList = new ListNode(listNode_m.val);
                    returnList = mergedList;
                } else {
                    mergedList.next = new ListNode(listNode_m.val);
                    mergedList = mergedList.next;
                }
                listNode_m = listNode_m.next;
            }

            if (listNode_m != null && listNode_n != null) {
                if (listNode_m.val <= listNode_n.val) {
                    if (mergedList == null) {
                        mergedList = new ListNode(listNode_m.val);
                        returnList = mergedList;
                    } else {
                        mergedList.next = new ListNode(listNode_m.val);
                        mergedList = mergedList.next;
                    }
                    listNode_m = listNode_m.next;
                } else {
                    if (mergedList == null) {
                        mergedList = new ListNode(listNode_n.val);
                        returnList = mergedList;
                    } else {
                        mergedList.next = new ListNode(listNode_n.val);
                        mergedList = mergedList.next;
                    }
                    listNode_n = listNode_n.next;
                }
            }
        }

        return returnList;
    }

    public static void main(String[] args) {

        MergeKSortedList ob = new MergeKSortedList();

        ListNode node1 = new ListNode();
        node1.val = 1;

        ListNode node2 = new ListNode();
        node2.val = 4;

        ListNode node3 = new ListNode();
        node3.val = 5;

        node1.next = node2;
        node2.next = node3;

        ListNode nodea = new ListNode();
        nodea.val = 1;

        ListNode nodeb = new ListNode();
        nodeb.val = 3;

        ListNode nodec = new ListNode();
        nodec.val = 4;

        nodea.next = nodeb;
        nodeb.next = nodec;

        ListNode test = new ListNode();
        test.val = 2;

        ListNode test1 = new ListNode();
        test1.val = 6;

        test.next = test1;

        ListNode[] lists = {node1, nodea, test};

        ListNode[] listA = {};

        ListNode result = ob.mergeKLists(lists);

        while(result != null) {
            System.out.print(result.val);
            System.out.print("    ");
            result = result.next;
        }

    }

}
