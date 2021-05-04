package com.rbhatt.bsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode problem # 102
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();


        if (root == null) {
            return result;
        }

        List<Integer> rootTempList = new ArrayList<>();
        rootTempList.add(root.val);
        result.add(rootTempList);

        if (root.left == null && root.right == null) {
            return result;
        }

        /*Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();*/

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tempQ = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        do {

            TreeNode node = queue.poll();

            if (node != null) {

                tempList.add(node.val);

                if (node.left != null) {
                    tempQ.add(node.left);
                }
                if (node.right != null) {
                    tempQ.add(node.right);
                }

            }

            if (queue.isEmpty() && !tempQ.isEmpty()) {
                result.add(tempList);
                tempList = new ArrayList<>();
                queue.addAll(tempQ);
                tempQ = new LinkedList<>();
            }

            if (queue.isEmpty() && tempQ.isEmpty()) {
                result.add(tempList);
            }

        } while (!queue.isEmpty());

        return result;
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal ob = new BinaryTreeLevelOrderTraversal();

        TreeNode t7 = new TreeNode(7);
        TreeNode t15 = new TreeNode(15);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t3 = new TreeNode(3, t9, t20);

        //System.out.println(ob.levelOrder(t3));

        TreeNode t1 = new TreeNode(1);
        System.out.println(ob.levelOrder(t1));

    }

}
