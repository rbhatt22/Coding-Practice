package com.rbhatt.tree;

//tree
//Leetcode question # 1430 (premium content)
public class ValidSequence {

    public boolean isValidSequence(TreeNode root, int[] arr) {

        TreeNode current = root;
        int i = 0;
        boolean found;

        found = recursion(current, arr, i);

        return found;
    }

    public boolean recursion(TreeNode current, int[] arr, int index) {

        if (current == null || index >= arr.length || current.val != arr[index]) {
            return false;
        }
        //check if leaf node
        if (current.left == null & current.right == null) {
            return true;
        }

        if (recursion(current.left, arr, index+1) || recursion(current.right, arr, index+1)) {
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {

        ValidSequence ob = new ValidSequence();

        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(0);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.right = f;
        e.left = g;


        System.out.println(ob.isValidSequence(a, new int[] {0, 1, 0, 1}));

        System.out.println(ob.isValidSequence(a, new int[] {0, 1, 1, 0}));

        System.out.println(ob.isValidSequence(a, new int[] {0,0}));

        System.out.println(ob.isValidSequence(a, new int[] {0,1}));
    }

}
