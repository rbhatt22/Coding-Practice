package com.rbhatt.tree;

import com.rbhatt.PracTest.Solution1;

import java.util.Stack;

//Tree

//Leetcode question # 1008
public class ConstructBSTFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode current = new TreeNode(preorder[0]);
        TreeNode result = current;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        for (int i = 1; i < preorder.length; i++) {

            TreeNode t = new TreeNode(preorder[i]);

            if (preorder[i] < preorder[i-1]) {
                stack.push(t);
                current.left = t;
            } else {
                while (!stack.empty() && stack.peek().val < preorder[i]) {
                    current = stack.pop();
                }
                current.right = t;
                stack.push(t);
            }

            current = t;
        }


        return result;
    }

    public static void main(String[] args) {

        ConstructBSTFromPreorderTraversal ob = new ConstructBSTFromPreorderTraversal();

        ob.bstFromPreorder(new int[] {8,5,1,7,10,12});

    }
}
