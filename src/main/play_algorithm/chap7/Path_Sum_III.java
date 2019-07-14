package main.play_algorithm.chap7;

import main.LeetCode.TreeNode;

public class Path_Sum_III {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int result = 0;
        result += findPath(root, sum);
        result += pathSum(root.left, sum);
        result += pathSum(root.right, sum);
        return result;
    }


    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (node.val == sum) {
            result += 1;
        }
        result += findPath(node.left, sum - node.val);
        result += findPath(node.right, sum - node.val);
        return result;
    }

}
