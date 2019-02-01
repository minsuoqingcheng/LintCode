package main.LeetCode.easy_1.question110;

import main.LeetCode.TreeNode;

public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;
    }


    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
