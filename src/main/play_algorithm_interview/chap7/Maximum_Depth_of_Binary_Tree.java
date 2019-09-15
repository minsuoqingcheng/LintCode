package main.play_algorithm_interview.chap7;

import main.LeetCode.TreeNode;

public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

}
