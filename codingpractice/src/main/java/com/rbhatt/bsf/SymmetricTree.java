package com.rbhatt.bsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode problem # 101
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
//Tree
//BFS
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queueLeft = new LinkedList<>();
        Queue<TreeNode> queueRight = new LinkedList<>();

        queueLeft.add(root.left);
        queueRight.add(root.right);

        while(!queueLeft.isEmpty() || !queueRight.isEmpty()) {

            TreeNode leftNode = queueLeft.poll();
            TreeNode rightNode = queueRight.poll();

            if (leftNode == null || rightNode == null) {
                if (!(rightNode == null && leftNode == null)) {
                    return false;
                }
            } else {
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                queueLeft.add(leftNode.left);
                queueRight.add(rightNode.right);
                queueLeft.add(leftNode.right);
                queueRight.add(rightNode.left);
            }

        }

        return queueLeft.isEmpty() && queueRight.isEmpty();
    }

    public static void main(String[] args) {

        SymmetricTree ob = new SymmetricTree();

        /*TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2left = new TreeNode(2, t3, t4);
        TreeNode t2right = new TreeNode(2, t4, t3);
        TreeNode t1 = new TreeNode(1, t2left, t2right);

        System.out.println(ob.isSymmetric(t1));*/

        /*TreeNode t3 = new TreeNode(3);
        TreeNode t2left = new TreeNode(2, null, t3);
        TreeNode t2right = new TreeNode(2, null, t3);
        TreeNode t1 = new TreeNode(1, t2left, t2right);

        System.out.println(ob.isSymmetric(t1));*/

        TreeNode t3 = new TreeNode(2);
        TreeNode t2left = new TreeNode(2, t3, null);
        TreeNode t2right = new TreeNode(2, t3, null);
        TreeNode t1 = new TreeNode(1, t2left, t2right);

        System.out.println(ob.isSymmetric(t1));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
