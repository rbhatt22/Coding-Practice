package com.rbhatt.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Leetcode question # 111
 * DFS
 * Tree
 * Recursive and non-recursive
 * Find minimum depth of a Binary Tree
 */
public class MinimumDeptBinaryTree {

    //non recursive solution
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int result = Integer.MAX_VALUE;

        TreeNodeAndDepth rootAndDepth = new TreeNodeAndDepth(root, 1);

        Queue<TreeNodeAndDepth> queue = new LinkedList<>();

        queue.add(rootAndDepth);

        while(!queue.isEmpty()) {

            TreeNodeAndDepth treeNodeAndDepth = queue.poll();

            if (treeNodeAndDepth.treeNode.left != null) {
                queue.add(new TreeNodeAndDepth(treeNodeAndDepth.treeNode.left, treeNodeAndDepth.depth + 1));
            }
            if (treeNodeAndDepth.treeNode.right != null) {
                queue.add(new TreeNodeAndDepth(treeNodeAndDepth.treeNode.right, treeNodeAndDepth.depth + 1));
            }

            if (treeNodeAndDepth.treeNode.left == null
                    && treeNodeAndDepth.treeNode.right == null
                    && treeNodeAndDepth.depth < result) {
                result = treeNodeAndDepth.depth;
            }
        }

        return result;
    }

    class TreeNodeAndDepth {
        TreeNode treeNode;
        int depth;

        TreeNodeAndDepth() {}

        TreeNodeAndDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    //Recursive solution
    public int minDepthRecursive(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepthRecursive(root.right) + 1;
        }
        if (root.right == null) {
            return minDepthRecursive(root.left) + 1;
        }

        int left = minDepthRecursive(root.left) + 1;
        int right = minDepthRecursive(root.right) + 1;

        return Math.min(left, right);

    }


    public static void main(String[] args) {

        MinimumDeptBinaryTree ob = new MinimumDeptBinaryTree();

        TreeNode root1 = new TreeNode(3);
        TreeNode root1L = new TreeNode(9);
        TreeNode root1R = new TreeNode(20);
        TreeNode root1RL = new TreeNode(15);
        TreeNode root1RR = new TreeNode(7);

        root1.left = root1L;
        root1.right = root1R;
        root1R.left = root1RL;
        root1R.right = root1RR;

        System.out.println(ob.minDepthRecursive(root1));

        TreeNode root2 = new TreeNode(2);
        TreeNode root2R = new TreeNode(3);
        TreeNode root2RR = new TreeNode(4);
        TreeNode root2RRR = new TreeNode(5);
        TreeNode root2RRRR = new TreeNode(6);

        root2.right = root2R;
        root2R.right = root2RR;
        root2RR.right = root2RRR;
        root2RRR.right = root2RRRR;

        System.out.println(ob.minDepthRecursive(root2));
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
