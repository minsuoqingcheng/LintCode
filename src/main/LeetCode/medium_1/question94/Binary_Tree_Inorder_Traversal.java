package main.LeetCode.medium_1.question94;

import main.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                nodes.push(current);
                current = current.left;
            }
            current = nodes.pop();
            ans.add(current.val);
            current = current.right;
        }
        return ans;
    }


}
