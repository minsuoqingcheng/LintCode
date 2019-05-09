package main.classify.tree;


import main.classify.basic.TreeNode;

import java.util.Stack;

public class Range_Sum_of_BST {

    public int rangeSumBST1(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                int val = node.val;
                if (val >= L && val <= R) {
                    ans += val;
                }
                //还可以试着向左扩展
                if (val > L && node.left != null) {
                    stack.push(node.left);
                }
                //还可以试着向右扩展
                if (val < R && node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }


    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum = sum + root.val;
            return sum + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }

        if (root.val > L && root.left != null)
            sum = sum + rangeSumBST(root.left, L, R);
        if (root.val < R && root.right != null)
            sum = sum + rangeSumBST(root.right, L, R);

        return sum;
    }

}
