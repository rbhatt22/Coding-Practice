package com.rbhatt.tree;

//Tree
//Leetcode question # 543
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

public class DiameterOfBinaryTree {

    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return result;
    }

    public int recursion(TreeNode current) {

        int right = 0;
        int left = 0;

        if (current == null) {
            return 0;
        }

        if (current.left != null) {
            left += 1;
        }
        if (current.right != null) {
            right +=1;
        }

        right = right + recursion(current.right);
        left = left + recursion(current.left);

        if (right + left > result) {
            result = right + left;
        }

        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {

        DiameterOfBinaryTree ob = new DiameterOfBinaryTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(ob.diameterOfBinaryTree(a));

        TreeNode aa = new TreeNode(1);
        TreeNode bb = new TreeNode(2);
        TreeNode cc = new TreeNode(3);
        TreeNode dd = new TreeNode(4);
        TreeNode ee = new TreeNode(5);
        TreeNode ff = new TreeNode(6);

        aa.right = bb;
        bb.left = cc;
        bb.right = dd;
        dd.right = ee;
        ee.right = ff;

        System.out.println(ob.diameterOfBinaryTree(aa));
    }

}
