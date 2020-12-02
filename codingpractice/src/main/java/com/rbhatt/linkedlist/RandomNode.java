package com.rbhatt.linkedlist;

/**
 * Leet code question # 382
 * December challenge day 2
 *
 * Return a random node value
 * Follow up: linked list size is unknown and it is extremely large. Solve it without using extra space.
 *
 * LinkedList
 * Reservoir Sampling
 */
public class RandomNode {

    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {

        int scope = 1;
        int result = 0;
        ListNode curr = this.head;

        while (curr != null) {

            if (Math.random() < 1.0 / scope) {
                result = curr.val;
            }
            scope++;
            curr = curr.next;
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        RandomNode ob = new RandomNode(node1);
        System.out.println(ob.getRandom());

    }

}
