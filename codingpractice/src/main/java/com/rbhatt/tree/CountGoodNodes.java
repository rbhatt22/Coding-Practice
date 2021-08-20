package com.rbhatt.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatt22 on 8/19/21.
 * Leetcode problem # 1448
 *Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

 Return the number of good nodes in the binary tree.
 *
 */
//tree
public class CountGoodNodes {

    //With custom class
    public int goodNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int goodNodes = 0;

        TreeNodeWithGoodValue rootWithGoodValue = new TreeNodeWithGoodValue(root, root.val);

        Queue<TreeNodeWithGoodValue> nodeQueue = new LinkedList<>();

        nodeQueue.add(rootWithGoodValue);

        while(!nodeQueue.isEmpty()) {

            TreeNodeWithGoodValue currentTreeNode = nodeQueue.poll();
            int goodValue = 0;

            if (currentTreeNode.treeNode.val >= currentTreeNode.goodValue) {
                goodNodes++;
                goodValue = currentTreeNode.treeNode.val;
            } else {
                goodValue = currentTreeNode.goodValue;
            }

            if (currentTreeNode.treeNode.left != null) {
                nodeQueue.add(new TreeNodeWithGoodValue(currentTreeNode.treeNode.left, goodValue));
            }
            if (currentTreeNode.treeNode.right != null) {
                nodeQueue.add(new TreeNodeWithGoodValue(currentTreeNode.treeNode.right, goodValue));
            }

        }
        return goodNodes;
    }

    int result = 0;
    public int goodNodesWithRecursion(TreeNode root) {

        recv(root, Integer.MIN_VALUE);
        return result;

    }

    public void recv(TreeNode root, int goodValue) {

        if (root == null) {
            return;
        }

        if (root.val >= goodValue) {
            result++;
            goodValue = root.val;
        }
        recv(root.left, goodValue);
        recv(root.right, goodValue);
    }

    public static void main(String[] args) {

        CountGoodNodes ob = new CountGoodNodes();

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;

        System.out.println(ob.goodNodes(t1));

        System.out.println(ob.goodNodesWithRecursion(t1));
    }

}

class TreeNodeWithGoodValue {

    TreeNode treeNode;
    int goodValue;

    TreeNodeWithGoodValue(TreeNode treeNode, int goodValue) {
        this.treeNode = treeNode;
        this.goodValue = goodValue;
    }
}
