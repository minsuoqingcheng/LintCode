package main.LeetCode.medium_1.question98;

import main.LeetCode.TreeNode;

import java.util.LinkedList;

public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lowerLimit, Integer upperLimit) {
        if (upperLimit != null && node.val >= upperLimit) { //左儿子
            return false;
        }
        if (lowerLimit != null && node.val <= lowerLimit) { //右儿子
            return false;
        }
        boolean left = node.left == null || helper(node.left, lowerLimit, node.val);
        if (left) {
            return node.right == null || helper(node.right, node.val, upperLimit);
        } else {
            return false;
        }
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> upper_limits = new LinkedList<>();
        LinkedList<Integer> lower_limits = new LinkedList<>();
        stack.add(root);
        upper_limits.add(null);
        lower_limits.add(null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower_limit = lower_limits.poll();
            Integer upper_limit = upper_limits.poll();
            if (node.right != null) {
                if (node.right.val > node.val) {
                    //这边判断的是左子树的右节点，不能大于根节点
                    if ((upper_limit != null) && (node.right.val >= upper_limit))
                        return false;
                    stack.add(node.right);
                    lower_limits.add(node.val);     //此时右节点作为根节点，更新右节点的左子树的判断标准，不能小于等于这个值
                    upper_limits.add(upper_limit);
                } else
                    return false;
            }

            if (node.left != null) {
                if (node.left.val < node.val) {
                    //这边判断的是右子树的左节点，不能小于根节点
                    if ((lower_limit != null) && (node.left.val <= lower_limit))
                        return false;
                    stack.add(node.left);
                    lower_limits.add(lower_limit);
                    upper_limits.add(node.val);     //此时左节点作为根节点，更新左节点的右子树的判断标准，不能大于等于这个值
                } else
                    return false;
            }
        }
        return true;
    }
}
