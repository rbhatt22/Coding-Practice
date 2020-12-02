package com.rbhatt.tree;

/**
 * //Leetocode question # 994
 * //Tree
 */
public class MaxDepth {

    public int findMaxDepth(TreeNode root) {

        int result_left = 0;
        int result_right = 0;

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null) {
            result_left = findDepth(root.left, 1);
        }
        if (root.right != null) {
            result_right = findDepth(root.right, 1);
        }

        return result_left > result_right ? result_left : result_right;
    }

    int findDepth(TreeNode node, int result) {

        if (node.left == null && node.right == null) {
            return result+1;
        }

        int result_left = 0;
        int result_right = 0;
        if (node.left != null) {
            result_left = findDepth(node.left, result);
        }
        if (node.right != null) {
            result_right = findDepth(node.right, result);
        }

        result = result + (result_left > result_right ? result_left : result_right);
        return result;
    }

    public static void main(String[] args) {

        MaxDepth ob = new MaxDepth();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(ob.findMaxDepth(node1));

        System.out.println(ob.findMaxDepth(null));

        TreeNode node21 = new TreeNode(0);
        System.out.println(ob.findMaxDepth(node21));

        TreeNode node31 = new TreeNode(1);
        TreeNode node32 = new TreeNode(2);

        node31.right = node32;

        System.out.println(ob.findMaxDepth(node31));

    }

}

