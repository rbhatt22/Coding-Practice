package com.rbhatt.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Tree
//Leetcode question # 124 (Hard)
public class BinaryTreeMaximumPathSum {

    int globalSum;
    public int maxPathSum(TreeNode root) {

        globalSum = Integer.MIN_VALUE;

        TreeNode current = root;

        recursion(current);

        return globalSum;
    }

    public int recursion(TreeNode current) {

        if (current.left == null && current.right == null) {
            if (globalSum < current.val) {
                globalSum = current.val;
            }
            return current.val;
        }

        int currentValue = current.val;
        int leftValue = Integer.MIN_VALUE;
        int leftCurrentSum = Integer.MIN_VALUE;
        int rightValue = Integer.MIN_VALUE;
        int rightCurrentSum = Integer.MIN_VALUE;
        int allSum = currentValue;

        if (current.left != null) {
            leftValue = recursion(current.left);
            leftCurrentSum = leftValue + currentValue;
            allSum = allSum + leftValue;
        }
        if (current.right != null) {
            rightValue = recursion(current.right);
            rightCurrentSum = rightValue + currentValue;
            allSum = allSum + rightValue;
        }

        int maxSum = Math.max(currentValue,
            Math.max(allSum,
                Math.max(Math.max(rightCurrentSum, rightValue),
                    Math.max(leftCurrentSum, leftValue))));
        if (globalSum < maxSum) {
            globalSum = maxSum;
        }

        int temp = leftCurrentSum < rightCurrentSum ? rightCurrentSum : leftCurrentSum;
        return temp < currentValue ? currentValue : temp;
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum ob = new BinaryTreeMaximumPathSum();

        TreeNode root1 = new TreeNode(1);
        TreeNode root1L = new TreeNode(2);
        TreeNode root1R = new TreeNode(3);

        root1.left = root1L;
        root1.right = root1R;

        System.out.println(ob.maxPathSum(root1));

        TreeNode root2 = new TreeNode(-10);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode b1 = new TreeNode(15);
        TreeNode b2 = new TreeNode(7);

        root2.left = a1;
        root2.right = a2;
        a2.left = b1;
        a2.right = b2;

        System.out.println(ob.maxPathSum(root2));

        TreeNode root3 = new TreeNode(0);

        System.out.println(ob.maxPathSum(root3));

        TreeNode root4 = new TreeNode(-2);
        TreeNode root4L = new TreeNode(1);

        root4.left = root4L;

        System.out.println(ob.maxPathSum(root4));

        TreeNode root5 = new TreeNode(1);
        TreeNode root5L = new TreeNode(-2);
        TreeNode root5R = new TreeNode(-3);
        TreeNode root5LL = new TreeNode(1);
        TreeNode root5LR = new TreeNode(3);
        TreeNode root5LLL = new TreeNode(-1);
        TreeNode root5RL = new TreeNode(-2);

        root5.left = root5L;
        root5.right = root5R;
        root5R.left = root5RL;
        root5L.left = root5LL;
        root5L.right = root5LR;
        root5LL.left = root5LLL;

        System.out.println(ob.maxPathSum(root5));

        //[-1,5,null,4,null,null,2,-4]
        TreeNode root6 = new TreeNode(-1);
        TreeNode root6L = new TreeNode(5);
        TreeNode root6LL = new TreeNode(4);
        TreeNode root6LLR = new TreeNode(2);
        TreeNode root6LLRR = new TreeNode(-4);

        root6.left = root6L;
        root6L.left = root6LL;
        root6LL.right = root6LLR;
        root6LLR.right = root6LLRR;

        System.out.println(ob.maxPathSum(root6));
    }
}
