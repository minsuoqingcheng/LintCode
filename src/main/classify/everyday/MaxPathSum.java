package main.classify.everyday;

import main.classify.basic.TreeNode;

public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     *     a
     *    / \
     *   b   c
     * 一共有三种情况
     * b+a+c
     * b+a+a的父节点
     * c+a+a的父节点
     * @param node
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //计算左边分支最大值
        int left = Integer.max(dfs(node.left), 0);
        //计算右边分支最大值
        int right = Integer.max(dfs(node.right), 0);

        max = Math.max(max, node.val + left + right);

        return node.val + Math.max(left, right);
    }

}
