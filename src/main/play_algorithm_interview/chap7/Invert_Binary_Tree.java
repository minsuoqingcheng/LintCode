package main.play_algorithm_interview.chap7;

import main.LeetCode.TreeNode;

public class Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
