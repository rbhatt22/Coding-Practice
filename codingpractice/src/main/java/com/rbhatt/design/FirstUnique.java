package com.rbhatt.design;

//Design
//Leetcode question - 30 day April challenge

import java.util.HashMap;
import java.util.Map;

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
public class FirstUnique {

    int nodesCount;
    ListNode head = new ListNode(999);
    ListNode tail = new ListNode(999);
    Map<Integer, ListNode> map;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        nodesCount = 0;
        head.next = tail;
        tail.prev = head;

        for (int i : nums) {
            if (map.containsKey(i)) {
                ListNode node = map.get(i);
                deleteNode(node);
            } else {
                ListNode newNode = new ListNode(i);
                map.put(i, newNode);
                insertAtTail(newNode);
            }
        }
    }

    public int showFirstUnique() {
        if (nodesCount == 0) {
            return -1;
        } else {
            return head.next.value;
        }
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            ListNode node = map.get(value);
            deleteNode(node);
        } else {
            ListNode newNode = new ListNode(value);
            map.put(value, newNode);
            insertAtTail(newNode);
        }
    }

    public void deleteNode(ListNode node) {
        if (node.next != null && node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            nodesCount--;
        }
    }

    public void insertAtTail(ListNode newNode) {
        ListNode previousNode = tail.prev;
        newNode.prev = previousNode;
        newNode.next = tail;
        tail.prev = newNode;
        previousNode.next = newNode;
        nodesCount++;
    }

    class ListNode {
        int value;
        ListNode prev;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        FirstUnique ob1 = new FirstUnique(new int[] {7,7,7,7,7,7});
        System.out.println(ob1.showFirstUnique());
        ob1.add(7);
        ob1.add(3);
        ob1.add(3);
        ob1.add(17);
        System.out.println(ob1.showFirstUnique());

    }

}
