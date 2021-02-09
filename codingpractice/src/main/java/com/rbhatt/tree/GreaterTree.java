package com.rbhatt.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Tree
 * Binary Tree
 * Greater Sum Tree
 * Leetcode question # 1039
 */
public class GreaterTree {

    int sum = 0;

    public TreeNode converBSTRecursive(TreeNode root) {

        recursiveFunction(root);

        return root;
    }

    private void recursiveFunction(TreeNode root) {

        if (root == null) {
            return;
        }

        recursiveFunction(root.right);
        sum += root.val;
        root.val = sum;
        recursiveFunction(root.left);

    }

    public TreeNode convertBST(TreeNode root) {

        TreeNode rootResult = root;

        List<TreeNode> visited = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        int total = 0;

        if (rootResult == null) {
            return null;
        }
        if (rootResult.left == null && rootResult.right == null) {
            return rootResult;
        }

        stack.push(rootResult);

        while(!stack.empty()) {
            if (stack.peek().right != null && !visited.contains(stack.peek().right)) {
                stack.push(stack.peek().right);
            } else {
                //first pop
                TreeNode temp = stack.pop();
                visited.add(temp);
                //then push left node of popped node
                if (temp.left != null) {
                    stack.push(temp.left);
                }
                total = total + temp.val;
                temp.val = total;
            }
        }
        return rootResult;
    }

    public static void main(String[] args) {
        GreaterTree ob = new GreaterTree();

        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node3 = new TreeNode(3);

        node4.right = node6;
        node4.left = node1;
        node1.right = node2;
        node1.left = node0;
        node6.right = node7;
        node6.left = node5;
        node7.right = node8;
        node2.right = node3;

        /*TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode nodem4 = new TreeNode(-4);
        TreeNode nodem2 = new TreeNode(-2);

        node3.left = node1;
        node1.left = node0;
        node0.left = nodem4;
        nodem4.right = nodem2;*/

        TreeNode resultRoot = ob.converBSTRecursive(node4);

        System.out.println(resultRoot.val);
        System.out.println(resultRoot.left.val);
        System.out.println(resultRoot.right.val);

    }


}
