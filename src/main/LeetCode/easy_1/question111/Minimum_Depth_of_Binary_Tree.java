package main.LeetCode.easy_1.question111;

import main.LeetCode.TreeNode;

public class Minimum_Depth_of_Binary_Tree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

}
